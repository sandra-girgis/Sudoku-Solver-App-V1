package com.example.sudokusolver;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    private SudokuBoard gameBoard;
    private Solver gameBoardSolver;
    private Button solveBTN;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        gameBoard = findViewById(R.id.sudokuBoard);
        gameBoardSolver = gameBoard.getSolver();
        solveBTN = findViewById(R.id.solve);


    }

    public void one(View view){
        gameBoardSolver.setNumberPos(1);
        gameBoard.invalidate();
    }

    public void two(View view){
        gameBoardSolver.setNumberPos(2);
        gameBoard.invalidate();
    }

    public void three(View view){
        gameBoardSolver.setNumberPos(3);
        gameBoard.invalidate();
    }

    public void four(View view){
        gameBoardSolver.setNumberPos(4);
        gameBoard.invalidate();
    }

    public void five(View view){
        gameBoardSolver.setNumberPos(5);
        gameBoard.invalidate();
    }

    public void six(View view){
        gameBoardSolver.setNumberPos(6);
        gameBoard.invalidate();
    }

    public void seven(View view){
        gameBoardSolver.setNumberPos(7);
        gameBoard.invalidate();
    }

    public void eight(View view){
        gameBoardSolver.setNumberPos(8);
        gameBoard.invalidate();
    }

    public void nine(View view){
        gameBoardSolver.setNumberPos(9);
        gameBoard.invalidate();
    }

    public void solve(View view){
        if (solveBTN.getText().toString().equals(getString(R.string.solveBTN))){
            solveBTN.setText(getString(R.string.clearBTN));

            gameBoardSolver.getEmptyBoxIndexes();
            SolveBoardThread solveBoardThread = new SolveBoardThread();
            new Thread(solveBoardThread).start();
            gameBoard.invalidate();
        }
        else{
            solveBTN.setText(getString(R.string.solveBTN));
            gameBoardSolver.resetBoard();
            gameBoard.invalidate();
        }
    }

    class SolveBoardThread implements  Runnable{
        @Override
        public void run(){
            gameBoardSolver.solve(gameBoard);
        }
    }
}