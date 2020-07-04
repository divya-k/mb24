package tests;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;

public class Matrix {

    public int creatureInfectedCount = 0;
    public int Incrementor = 1;
    public int zombieMovementCounter = 1;
    static final String USAGE = "Usage:ntjava App server port";
    static final String MSG_TOO_FEW_ARGUMENTS  = "too few arguments";
    static final String MSG_TOO_MANY_ARGUMENTS = "too many arguments";
    
    public static void main(String... args) throws IOException {

        if (args.length < 2) {
            System.out.println(MSG_TOO_FEW_ARGUMENTS);
        } else if (args.length > 2)
            System.out.println(MSG_TOO_MANY_ARGUMENTS);
        System.out.println(USAGE);

        Matrix test = new Matrix();

        int gridSize = test.readconsole("Enter matrix size ");
        System.out.println("Grid of size " + gridSize + " x " + gridSize + " created");
        int[][] twoD_arr = new int[gridSize][gridSize];
        test.initialse_grid(twoD_arr);
        test.display_grid(twoD_arr);
        
        test.read_and_mark_creators_in_grid(twoD_arr);
        test.display_grid(twoD_arr);

        int[] coordinates = test.read_and_mark_zombie_coordinates(twoD_arr);
        test.display_grid(twoD_arr);

        String route = test.read_navigation_route_from_console("Specify navigation : ");
        int zombieloopnum = 999;
        test.display_grid(twoD_arr);
        System.out.println("Zombie started movement in the path specified");
        test.start_zombie_action(twoD_arr, route, gridSize, coordinates[0], coordinates[1], zombieloopnum);
        System.gc();
    }
    public int[] read_and_mark_zombie_coordinates(int[][] twoD_arr) {
        System.out.print("Specify in which Grid zombie need to be placed as in format x,x :");
        Scanner scan = new Scanner(System.in);
        String zombieCoordinates = scan.nextLine();
        String[] coordinates = zombieCoordinates.split(",");
        System.out.println("Zombie placed at its initial location : ("+Integer.parseInt(coordinates[0])+","+Integer.parseInt(coordinates[1])+") for movement");
        twoD_arr[Integer.parseInt(coordinates[0])][Integer.parseInt(coordinates[0])] = 998;
        int[] temp = new int[2];
        temp[0] = Integer.parseInt(coordinates[0]);
        temp[1] = Integer.parseInt(coordinates[1]);
        return temp;
    }
    public void read_and_mark_creators_in_grid(int[][] twoD_arr) {
        System.out.println("Specify grid location as x,x x,x where creators need to be placed");
        Scanner scan = new Scanner(System.in);
        String user_input = scan.nextLine();
        String[] numberpair = user_input.split(" ");
        System.out.println("Number of creators placed : "+numberpair.length);

        int[][] intArray = new int[numberpair.length][2];
        for (int i = 0; i < numberpair.length; i++) {
            String[] temp = numberpair[i].split(",");
            intArray[i][0] = Integer.parseInt(temp[0]);
            intArray[i][1] = Integer.parseInt(temp[1]);
        }
        System.out.println("Read creator grid as ");
        for (int[] ints : intArray) {
            System.out.println(ints[0] + " , " + ints[1]);
            twoD_arr[ints[0]][ints[1]] = 111;
        }
        System.out.println("Placed creators in grid as below ");
    }
    public void start_zombie_action(int[][] twoD_arr,String route,int gridSize,int currx, int curry, int zombieloopnum) {
        this.navigate(twoD_arr, route, gridSize, currx, curry, zombieloopnum);

        this.display_grid(twoD_arr);
        int[] newcoordinates={0,0};
        while(creatureInfectedCount>0) {
            creatureInfectedCount = creatureInfectedCount-1;
            newcoordinates = this.getMinValue(twoD_arr);
            zombieloopnum= zombieloopnum-1;
            twoD_arr[newcoordinates[0]][newcoordinates[1]]=zombieloopnum-1;
            this.navigate(twoD_arr, route,gridSize, newcoordinates[0], newcoordinates[1],zombieloopnum);
        }
    }
    public void navigate(int[][] twoD_arr, String route,int size,int currx,int curry,int Zoombieloopnum) {
        char move;

        for (int i=0; i<route.length();i++) {
            move = route.charAt(i);
            switch (move) {
                case 'l':
                case 'L': curry = (curry-1 < 0) ? size-1 : curry-1;
                    System.out.println( move +" -> ( "+currx+" , "+curry+ ")");
                    if (twoD_arr[currx][curry] == 111) {
                        creatureInfectedCount++;
                        twoD_arr[currx][curry] = Incrementor++;
                    }else if(twoD_arr[currx][curry] >= Zoombieloopnum){
                        twoD_arr[currx][curry] = Zoombieloopnum-1;
                    }
                    zombieMovementCounter++;
                    this.display_grid(twoD_arr);
                    break;
                case 'r':
                case 'R': curry = (curry+1 > size-1) ? 0 : curry+1;
                    System.out.println( move +" -> ( "+currx+" , "+curry+ ")");
                    if (twoD_arr[currx][curry] == 111){
                        creatureInfectedCount++;
                        twoD_arr[currx][curry] = Incrementor++;
                    }else if(twoD_arr[currx][curry] >= Zoombieloopnum) {
                        twoD_arr[currx][curry] = Zoombieloopnum-1;
                    }
                    zombieMovementCounter++;
                    this.display_grid(twoD_arr);
                    break;
                case 'u':
                case 'U': currx = (currx-1 < 0) ? size-1 : currx-1;
                    System.out.println( move +" -> ( "+currx+" , "+curry+ ")");
                    if (twoD_arr[currx][curry] == 111) {
                        creatureInfectedCount++;
                        twoD_arr[currx][curry] = Incrementor++;
                    }else if(twoD_arr[currx][curry] >= Zoombieloopnum) {
                        twoD_arr[currx][curry] = Zoombieloopnum-1;
                    }

                    zombieMovementCounter++;
                    this.display_grid(twoD_arr);
                    break;
                case 'd':
                case 'D': currx = (currx+1 > size-1) ? 0 : currx+1;
                    System.out.println( move +" -> ( "+currx+" , "+curry+ ")");
                    if (twoD_arr[currx][curry] == 111) {
                        creatureInfectedCount++;
                        twoD_arr[currx][curry] = Incrementor++;
                    }else if(twoD_arr[currx][curry] >= Zoombieloopnum) {
                        twoD_arr[currx][curry] = Zoombieloopnum-1;
                    }

                    zombieMovementCounter++;
                    this.display_grid(twoD_arr);
                    break;
            }
        }
        System.out.println("Number of creators infected is : "+creatureInfectedCount);
        System.out.println("Zombie has traversed "+(zombieMovementCounter)+" number of grids");

    }
    public int readconsole(String inputMessage) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        System.out.println(inputMessage);
        return Integer.parseInt(reader.readLine());
    }

    public String read_navigation_route_from_console(String inputMessage) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        System.out.print(inputMessage);
        return reader.readLine();
    }
    public void initialse_grid(int[][] grid) {
        int length = grid.length;
        for(int i =0; i<length; i++) {
            for(int j=0; j<length; j++) {
                grid[i][j] = 999;
            }
        }
        System.out.println("Grid initilised as below ");
    }

    public void display_grid(int[][] grid) {
        int length = grid.length;
        for (int[] ints : grid) {
            for (int j = 0; j < length; j++) {
                System.out.print(ints[j] + ",");
            }
            System.out.println();
        }
    }

    public int[] getMinValue(int[][] numbers) {
        int minValue = numbers[0][0];
        int[] coordinates={0,0};
        for (int j = 0; j < numbers.length; j++) {
            for (int i = 0; i < numbers[j].length; i++) {
                if (numbers[j][i] < minValue ) {
                    minValue = numbers[j][i];
                    coordinates[0]= j;
                    coordinates[1]= i;
                }
            }
        }
        System.out.println("Next infected creature at ("+coordinates[0]+" , "+coordinates[1]+") is following the same path and attach other creatures");
        return coordinates ;
    }
}

