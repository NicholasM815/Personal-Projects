#Author: Nicholas Milonni

#This project is a Tic Tac Toe game. It contains five functions that are
#responsible for creating a Tic Tac Toe board, and allowing the
#game to be played between two people. The board is constructed using a sequence
#of three lists, and is modified through user input.

#This function is called every time a new move is made.
#It serves to check if either player has won yet. Additionally, 
#it also keeps track of how many moves have been made in the 
#game, because if nine moves are made without any winner, 
#the game will result in a draw.

def check_for_win(player, first_row, second_row, third_row, moves_made):

    #Checking to see if the first row all matches:
    if first_row[0] == "A" and first_row[1] == "A" and first_row[2] == "A":
        print(player + " wins")
        exit()
    
    elif first_row[0] == "B" and first_row[1] == "B" and first_row[2] == "B":
        print(player + " wins")
        exit()

    #Checking to see if the second row all matches:
    if second_row[0] == "A" and second_row[1] == "A" and second_row[2] == "A":
        print(player + " wins")
        exit()
    
    elif second_row[0] == "B" and second_row[1] == "B" and second_row[2] == "B":
        print(player + " wins")
        exit()

    #Checking to see if the third row all matches:
    if third_row[0] == "A" and third_row[1] == "A" and third_row[2] == "A":
        print(player + " wins")
        exit()

    if third_row[0] == "B" and third_row[1] == "B" and third_row[2] == "B":
        print(player + " wins")
        exit()

    #Checking to see if the first column all matches:
    
    if first_row[0] == "A" and second_row[0] == "A" and third_row[0] == "A":
        print(player + " wins")
        exit()
    
    if first_row[0] == "B" and second_row[0] == "B" and third_row[0] == "B":
        print(player + " wins")
        exit()
    
    #Checking to see if the second column all matches:
    if first_row[1] == "A" and second_row[1] == "A" and third_row[1] == "A":
        print(player + " wins")
        exit()
    
    if first_row[1] == "B" and second_row[1] == "B" and third_row[1] == "B":
        print(player + " wins")
        exit()
    
    #Checking to see if the third column all matches:
    if first_row[2] == "A" and second_row[2] == "A" and third_row[2] == "A":
        print(player + " wins")
        exit()
    
    if first_row[2] == "B" and second_row[2] == "B" and third_row[2] == "B":
        print(player + " wins")
        exit()

    #Checking to see if the first diagonal all matches:
    if first_row[0] == "A" and second_row[1] == "A" and third_row[2] == "A":
        print(player + " wins")
        exit()
    
    if first_row[0] == "B" and second_row[1] == "B" and third_row[2] == "B":
        print(player + " wins")
        exit()
    
    #Checking to see if the second diagonal all matches:
    if first_row[2] == "A" and second_row[1] == "A" and third_row[0] == "A":
        print(player + " wins")
        exit()
    
    if first_row[2] == "B" and second_row[1] == "B" and third_row[0] == "B":
        print(player + " wins")
        exit()
    
    #If all spots are filled without three in a row:
    elif moves_made == 9:
        print("The game has resulted in a draw")
        exit()

#This function is responsible for allowing the players to
#make moves. It can also tell if the position a player is
#trying to fill is full, in which case it will ask the user
#to try a different position. It will also increment the
#moves made each time a new move is completed.
#This is important in case there is no winner before the
#game is over.

def make_move(row, column, player, first_row, second_row, third_row, moves_made):
    player_mark = "0"

    if player == "Player 1":
        player_mark = "A"

    elif player == "Player 2":
        player_mark = "B"

    #Making a move in row 1, in the specified column.
    #Also making sure that the position entered by the
    #user is not full.

    if row == "1":
        column_number = int(column) #cast to int
        if column_number != 0:
            column_number = column_number - 1
            
        if first_row[column_number] == "O":
            first_row[column_number] = player_mark
            moves_made = moves_made + 1

        else:
            print("This position is already full. Pick another.")
            print_out(player, first_row, second_row, third_row, moves_made)
    
    #Making a move in row 2, in the specified column.
    #Also making sure that the position entered by the user
    #is not full.

    elif row == "2":
        column_number = int(column) #cast to int
        if column_number != 0:
            column_number = column_number - 1

        if second_row[column_number] == "O":
            second_row[column_number] = player_mark
            moves_made = moves_made + 1

        else:
            print("This position is already full. Pick another.")
            print_out(player, first_row, second_row, third_row, moves_made)

    #Making a move in row 3, in the specified column.
    #Also making sure that the position entered by the 
    #user is not full already.

    else:
        column_number = int(column) #cast to int
        if column_number != 0:
            column_number = column_number - 1
        
        if third_row[column_number] == "O":
            third_row[column_number] = player_mark
            moves_made = moves_made + 1
        
        else:
            print("This position is already full. Pick another.")
            print_out(player, first_row, second_row, third_row, moves_made)
    
    print_board(first_row, second_row, third_row)

    #Checking to see if either player has won, or if it is a draw:
    check_for_win(player, first_row, second_row, third_row, moves_made) 

    #Sawpping between players:
    if player == "Player 1":
        print_out("Player 2", first_row, second_row, third_row, moves_made)
    
    else:
        print_out("Player 1", first_row, second_row, third_row, moves_made)

#This function is called by the make_move function, and will display
#the current game of Tic Tac Toe, by printing each row. It will be called
#each time a new move is made, to ensure the players are aware of what the
#Tic Tac Toe board looks like.

def print_board(first_row, second_row, third_row):
    print()
    print("[" + first_row[0] + "][" + first_row[1] + "][" + first_row[2] + "]")
    print("[" + second_row[0] + "][" + second_row[1] + "][" + second_row[2] + "]")
    print("[" + third_row[0] + "][" + third_row[1] + "][" + third_row[2] + "]")
    print()

#This function will be called by the main function,
#as well as the make_move function. It is responsible for 
#explaining the current gamestate, including who's turn
#it is, which moves are from which player, and what
#empty spaces look like. It also gathers user input
#which it will then use to make moves in the game.
#It also lets the user know if the input is invalid,
#and asks them to enter it again.

def print_out(player, first_row, second_row, third_row, moves_made):
    print()
    print("It is " +  player + "'s turn.")
    print()
    print("Moves by player 1 are marked by 'A'")
    print("Moves by palyer 2 are marked by 'B'")
    print("Empty spaces are marked by 'O'")
    print()

    found_space = False

    while found_space == False: #If a space has been found, stop the loop.
        answer = input("Enter the space the want to fill, as 'row, collumn':")
        print()
        final_answer = answer.split(", ") #split up the input, to get a row and column.
        
        if final_answer[0] != "1" and final_answer[0] != "2" and final_answer[0] != "3":
            print("Improper input. Both numbers have to be 1, 2, or 3.")
            print("The numbers must also be divided by a space and comma. Example: '1, 3'")

        elif final_answer[1] != "1" and final_answer[1] != "2" and final_answer[1] != "3":
            print("Improper input. Both numbers have to be 1, 2, or 3.")
            print("The numbers must also be divided by a space and comma. Example: '1, 3'")
        
        else:
            row = final_answer[0]
            column = final_answer[1]

            make_move(row, column, player, first_row, second_row, third_row, moves_made)
            found_space = True

#The main function is the starting point.
#It prints the introduction, as well as calls
#the print_out function to begin the game. It also
#creates the moves_made variable, which will be used
#in other functions such as make_move, and check_for_win.
    
def main():
    #All three rows and collumns of the board:
    first_row = ["O", "O", "O"]
    second_row = ["O", "O", "O"]
    third_row = ["O", "O", "O"]

    print("Welcom to the Tic-Tac-Toe game!")
    print()
    print("[" + first_row[0] + "][" + first_row[1] + "][" + first_row[2] + "]")
    print("[" + second_row[0] + "][" + second_row[1] + "][" + second_row[2] + "]")
    print("[" + third_row[0] + "][" + third_row[1] + "][" + third_row[2] + "]")

    #Varaible for keeping track of how many spaces on the board are filled:
    moves_made = 0 

    print_out("Player 1", first_row, second_row, third_row, moves_made)

main()