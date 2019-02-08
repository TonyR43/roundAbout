package com.company;

public class Main
    {
        
        public static void main(String[] args)
            {
                final int STARTING_POSITION = 0;
                final int WINNING_POSITION = 12;
                final int SIDES_OF_DICE = 6;
                
                //int dieRoll = random.nextInt(SIDES_OF_DICE) + 1;
                java.util.Random random = new java.util.Random();
                int playerOnePosition = STARTING_POSITION;
                int playerTwoPosition = STARTING_POSITION;
                int turnCounter = 1;
                boolean playerOneTurn = true;
                
                do
                {
                    int dieRoll = random.nextInt(SIDES_OF_DICE) + 1;
                    int dieRoll2 = random.nextInt(SIDES_OF_DICE) + 1;
                    int dieTotal = dieRoll + dieRoll2;
                    
                    //----------------------------------------------
                    
                    if (playerOneTurn)
                    {
                        int rollNeeded;
                        if (playerOnePosition == 0)
                        {
                            rollNeeded = 5;
                        }
                        else
                        {
                            rollNeeded = playerOnePosition + 1;
                        }
                        
                        System.out.println("Dice One: " + dieRoll + "   Dice Two: " + dieRoll2 + "    Dice Total: " + dieTotal + "  Need: " + playerOnePosition);
                        
                        boolean moveForward = (dieRoll == rollNeeded || dieRoll2 == rollNeeded || dieTotal == rollNeeded);
                        if (moveForward)
                        {
                            playerOnePosition = playerOnePosition + 1;
                            
                            if (playerOnePosition == playerTwoPosition)
                            {
                                playerOnePosition = STARTING_POSITION;
                            }
                        }
                        turnCounter ++;
                    }
                    else
                    {
                        int rollNeeded;
                        if (playerTwoPosition == 0)
                        {
                            rollNeeded = 5;
                        }
                        else
                        {
                            rollNeeded = playerTwoPosition + 1;
                        }
                        
                        System.out.println("Dice One: " + dieRoll + "   Dice Two: " + dieRoll2 + "    Dice Total: " + dieTotal + "  Need: " + playerTwoPosition);
                        
                        boolean moveForward = (dieRoll == rollNeeded || dieRoll2 == rollNeeded || dieTotal == rollNeeded);
                        if (moveForward)
                        {
                            playerTwoPosition = playerTwoPosition + 1;
                            if (playerOnePosition == playerTwoPosition)
                            {
                                playerOnePosition = STARTING_POSITION;
                            }
                        }
                        turnCounter ++;
                    }
                    
                    
                    //----------------------------------------------------------------
                    System.out.println("Player one at position: " + playerOnePosition);
                    System.out.println("Player two at position: " + playerTwoPosition);
                    playerOneTurn = !playerOneTurn;
                    System.out.println("*************************************************************************************");
                }
                while (playerOnePosition < WINNING_POSITION && playerTwoPosition < WINNING_POSITION);
                
                if (playerOnePosition == WINNING_POSITION)
                {
                    System.out.println("Player one Wins!");
                }
                else
                {
                    System.out.println("Player two Wins!");
                }
                System.out.println("This game took " + turnCounter + " turns to complete.");
            }
    }