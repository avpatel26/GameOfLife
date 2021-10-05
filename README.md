# Conway's Game of Life

This repository implements the cellular automaton, Conway's game of life. 

## Repository structure
```
.
├── Game.java : implementation of game of life
└── input.txt : sample input file
```
## Structure of Input File

Input(text) file contains the comma seperated value of initially alive grid cells.(No space in between and each value on a newline) \
e.g. for grid[1][1], grid[1][5]
```
1,1
1,5
```
Empty file is considered as a dead grid with 0 cell alive. \
Wrong formate raises the exception.

## Instruction for Running The Code

Run following code for compilation and execution. \
<Input_file> : initial grid text file

```
javac Game.java
java Game <Input_file>
```
