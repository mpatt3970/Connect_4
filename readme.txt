Michael Patterson	10547640
Java
For interactive mode, the gui files are GUI, Interactive, Control, and JScore. GUI holds Interactive and Control. Control holds JScore. JScore displays current turn and the current score. Interactive is a JComponent with a MouseClickListener. When a mouse is clicked, it registers that as the human's move and makes the next AI move. It also draws the current gameBoard.
When interactive mode is an argument, it makes the computer move if "computer-next" or "C" or is an argument. Then it instantiates the GUI class and allows play to continue.
For one-move mode, it prints the current game board to the console. Then it makes the AI player make a move. Then it prints the resulting game board with some info. It also stores the resulting game board to a file.
All of the AI decision making is encompassed in AiPlayer.findBestPlay.

To run:
Unzip the project. cd PROJECT/bin | java mines/mipatter/maxconnect4 (with the desired arguments)
NOTE_1: the txt files are stored in the PROJECT directory so they must be entered as ../fileName.txt
NOTE_2: PROJECT refers to the project directory, in this case project2