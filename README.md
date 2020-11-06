# game-laser-Beam-GLB
# Game laser beam GLB


Game Laser Beam GLB is a program developed in java with help
from an integrated development environment (IDE) called IntelliJ IDEA developed by JetBrains. This is a program that allows to evaluate the reasoning capacity of the staff that is hired by the institute mirrors, lasers and mazes. The program is simple and can be seen as a game. It consists of presenting the player with a grid or table with a number of rows and letters from A to Z depending on the number of columns, within which there are a series of invisible mirrors where some lean to the right and others to the right . on the left, these mirrors are arranged randomly.

## Game instructions

When starting the game, a main menu will be displayed that will give you three options such as: start, see leaderboard and exit the game.

### (1).Start Game:
The game will ask the player to enter the nickname followed by the number of rows, columns, and mirrors they wish to play with.Then a submenu will be displayed that will give you three other options such as:

#### ---> 1.Shoot a laser beam:

To fire a laser beam, you must enter the number of the row and the letter of the column.

#### ---> 2.Guess the location of a mirror:

To guess the location of a mirror, the player must enter the number of the row, the letter of the column and the inclination of the mirror, if it is to the right he must enter the letter R and if it is to the left he must enter the letter L , ALL VALUES MUST BE ENTER TRACKED WITHOUT SPACES.

#### ---> 3.Back to main menu:

Finally with this option, you must return to the main menu.

### (2).See position list:

If the player gives the option number two, a list will be displayed with the nicknames and the score that the player has marked, this list will be organized from highest to lowest.

### (3).Exit game:

With this option the game will be closed completely.

## Usage

```java
Initial table
   A  B  C  D  E 
1 [ ][ ][ ][ ][ ]
2 [ ][ ][ ][ ][ ]
3 [ ][ ][ ][ ][ ]
4 [ ][ ][ ][ ][ ]
5 [ ][ ][ ][ ][ ]

Table after firing a laser beam
select 4C
NickName ----> PAOLA || Points ----> 0
   A  B  C  D  E 
1 [ ][ ][ ][ ][ ]
2 [ ][ ][ ][ ][ ]
3 [ ][ ][ ][ ][ ]
4 [ ][ ][S][ ][ ]
5 [ ][ ][E][ ][ ]

Table after guessing the location of a mirror

NickName ----> PAOLA || Points ----> 1
select 2B
   A  B  C  D  E 
1 [ ][ ][ ][ ][ ]
2 [ ][/][ ][ ][ ]
3 [ ][ ][ ][ ][ ]
4 [ ][ ][ ][ ][ ]
5 [ ][ ][ ][ ][ ]

```
