import subprocess
import os
import time

# Function to run PowerShell commands from Python
def run_powershell_command(command):
    try:
        result = subprocess.run(['powershell', '-Command', command], capture_output=True, text=True)
        if result.returncode != 0:
            print(f"Error executing PowerShell command: {result.stderr}")
        else:
            print(f"Command output: {result.stdout}")
    except Exception as e:
        print(f"Failed to run PowerShell command: {str(e)}")

# Function to run netsh (Windows Firewall configuration)
def run_netsh_command(command):
    try:
        result = subprocess.run(['netsh', 'advfirewall', 'firewall', command], capture_output=True, text=True)
        if result.returncode != 0:
            print(f"Error executing netsh command: {result.stderr}")
        else:
            print(f"Command output: {result.stdout}")
    except Exception as e:
        print(f"Failed to run netsh command: {str(e)}")

# 1. Flush existing iptables rules (Windows equivalent using netsh)
def flush_firewall_rules():
    print("Flushing existing firewall rules...")
    # Disable the firewall first to flush existing rules (or you can reset them to default)
    run_netsh_command('set allprofiles state off')  # Disable firewall
    time.sleep(2)
    # Reset firewall rules (this is akin to flushing iptables)
    run_netsh_command('reset')  # Reset firewall settings

# 2. Set default policies to DROP all incoming, outgoing, and forwarded packets
def set_default_policy_drop():
    print("Setting default policies to DROP all traffic...")
    # Set default block for incoming, outgoing, and forwarded packets
    run_netsh_command('set allprofiles firewallpolicy blockinbound,blockoutbound')

# 3. Allow incoming traffic on loopback interface (127.0.0.1)
def allow_loopback_traffic():
    print("Allowing incoming traffic on loopback interface...")
    run_netsh_command('add rule name="Allow Loopback" protocol=TCP dir=in localport=0 action=allow remoteip=127.0.0.1')

# 4. Allow incoming and outgoing connections on ports 21115-21117
def allow_ports_21115_21117():
    print("Allowing incoming and outgoing traffic on ports 21115-21117...")
    # Allow incoming and outgoing traffic on the specified ports (21115-21117)
    for port in range(21115, 21118):
        run_netsh_command(f'add rule name="Allow Port {port}" protocol=TCP dir=in localport={port} action=allow')
        run_netsh_command(f'add rule name="Allow Port {port}" protocol=TCP dir=out localport={port} action=allow')

# 5. Disable autorun programs by clearing registry entries and removing items in the Startup folder
def disable_autorun_programs():
    print("Disabling autorun programs...")
    # Disable autorun programs by clearing the startup registry keys (both HKCU and HKLM)
    registry_paths = [
        "HKCU:\\Software\\Microsoft\\Windows\\CurrentVersion\\Run",
        "HKLM:\\Software\\Microsoft\\Windows\\CurrentVersion\\Run",
        "HKLM:\\Software\\WOW6432Node\\Microsoft\\Windows\\CurrentVersion\\Run"
    ]

    for path in registry_paths:
        # List registry entries
        result = subprocess.run(['powershell', f"Get-ItemProperty -Path '{path}'"], capture_output=True, text=True)
        if result.stdout:
            print(f"Removing autorun entries in {path}")
            run_powershell_command(f"Remove-ItemProperty -Path '{path}' -Name '*'")

    # Optionally, remove from Startup folder (for user-specific startup apps)
    startup_folder = os.path.join(os.environ['APPDATA'], 'Microsoft\\Windows\\Start Menu\\Programs\\Startup')
    for file in os.listdir(startup_folder):
        file_path = os.path.join(startup_folder, file)
        if os.path.isfile(file_path):
            print(f"Removing autorun file from startup folder: {file}")
            os.remove(file_path)

# 6. Disable unnecessary ICMP types (e.g., ICMP redirects)
def disable_icmp_types():
    print("Disabling unnecessary ICMP types...")
    # Disable ICMP redirects using PowerShell (which could be used in MITM attacks)
    run_powershell_command('Set-NetIPInterface -InterfaceAlias "Ethernet" -WeakHostSend Disable')

# 7. Restart the system to apply changes
def restart_system():
    print("Restarting the system to apply changes...")
    time.sleep(5)  # Pause for 5 seconds before restarting
    run_powershell_command('Restart-Computer -Force')

# 8. Change passwords for specified user accounts
def change_passwords():
    print("Changing passwords for all users...")
    # Set a new password for the Administrator account and any other relevant accounts
    new_password = "NewPassword123!"  # You can customize this password
    user_accounts = ["Administrator", "User1"]  # List of accounts to change password for

    for user in user_accounts:
        run_powershell_command(f'Set-LocalUser -Name "{user}" -Password (ConvertTo-SecureString "{new_password}" -AsPlainText -Force)')

# 9. Set up Windows Event Logging to monitor ICMP activity
def enable_icmp_event_logging():
    print("Setting up event logging to monitor ICMP activity...")
    # Enable Windows Event Logging for ICMP (this could capture suspicious ICMP traffic)
    run_powershell_command('New-WinEventLog -LogName "Application" -Source "ICMP"')
    run_powershell_command('Enable-WindowsEvent -LogName "Security"')

# Main execution logic
def main():
    print("Starting security hardening tasks...")

    # Step 1: Flush existing firewall rules
    flush_firewall_rules()

    # Step 2: Set default policies to DROP all traffic
    set_default_policy_drop()

    # Step 3: Allow incoming traffic on loopback interface
    allow_loopback_traffic()

    # Step 4: Allow incoming and outgoing connections on ports 21115-21117
    allow_ports_21115_21117()

    # Step 5: Disable autorun programs
    disable_autorun_programs()

    # Step 6: Disable unnecessary ICMP types
    disable_icmp_types()

    # Step 7: Restart the system
    restart_system()

    # After reboot, continue with further actions
    print("System restarted. Continuing with additional security measures...")

    # Step 8: Change passwords
    change_passwords()

    # Step 9: Enable ICMP Event Logging
    enable_icmp_event_logging()

    print("Security tasks completed!")

# Run the main function
if __name__ == "__main__":
    main()
