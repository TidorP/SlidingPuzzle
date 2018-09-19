package vac.Slidingpuzzle;

import vac.Pairr;

import java.util.*;

public class AssmebleAStar {
    private static boolean equals(int[][]first,int[][]second)
    {
        if(first.length!=second.length)
            return false;
        for(int i=0;i<first.length;i++) {
            for (int j = 0; j < second.length; j++) {
                if (first[i][j] != second[i][j])
                    return false;
            }
        }
        return true;
    }
    static Pairr<Integer,Integer> find_indexes(int[][]table,int value)
    {
        for(int i=0;i<table.length;i++) {
            for (int j = 0; j < table.length; j++) {
                if (table[i][j] == value)
                {
                    return new Pairr<Integer,Integer>(i,j);
                }
            }
        }
        return null;
    }
    public static int Manhattan(int[][]first,int[][]second)
    {
        int distance=0;
        for(int i=0;i<first.length;i++) {
            for (int j = 0; j < first.length; j++) {
                if(first[i][j]!=0) {
                    Pairr<Integer,Integer> pair=find_indexes(second, first[i][j]);
                    distance += Math.abs(i - pair.getFirst()) + Math.abs(j - pair.getSecond());
                }
            }
        }
        return distance;
    }
    static void solve(NodA n,int[][] Final)
    {
        PriorityQueue<NodA> q=new PriorityQueue<NodA>(1000,new Comparator<NodA>() {
        public int compare(NodA obj1, NodA obj2) {
            if(obj1.getLevel()+Manhattan(obj1.getPuzzle().getTablou(),Final)<(obj2.getLevel()+Manhattan(obj2.getPuzzle().getTablou(),Final)))
                return -1;
            else
                return 1;
        }
    });
        //Queue<NodA> q = new LinkedList<NodA>();
        q.add(n);
        while(!q.isEmpty()) {
            NodA nod=q.remove();
            //System.out.println("Am trecut la nodul:");
            Puzzle puzzle = nod.getPuzzle();
           // puzzle.showTable();

            if(equals(puzzle.getTablou(),Final)) {
                System.out.println();
                System.out.println("Path ul este:");
                nod.getPath().forEach(Puzzle::showTable);
                break;
            }
            else {
                if (nod.getLastMove() != "up") {
                    Puzzle copy1 = new Puzzle(puzzle);
                    Puzzle p1 = new Puzzle(copy1.move_down());
                    if (p1.getTablou().length != 0) {
                        List<Puzzle> path=new ArrayList<>(nod.getPath());
                        int distance=nod.getLevel();
                        NodA child = new NodA(p1, "down",path,distance+1);
                        child.addPath(p1);
                        nod.insert(child);
                        q.add(child);
                    }
                }
                if (nod.getLastMove() != "down") {
                    Puzzle copy2 = new Puzzle(puzzle);
                    Puzzle p2 = new Puzzle(copy2.move_up());
                    if (p2.getTablou().length != 0) {
                        List<Puzzle> path=new ArrayList<>(nod.getPath());
                        int distance=nod.getLevel();
                        NodA child = new NodA(p2, "up",path,distance+1);
                        child.addPath(p2);
                        nod.insert(child);
                        q.add(child);
                    }
                }
                if (nod.getLastMove() != "right") {
                    Puzzle copy3 = new Puzzle(puzzle);
                    Puzzle p3 = new Puzzle(copy3.move_left());
                    if (p3.getTablou().length != 0) {
                        List<Puzzle> path=new ArrayList<>(nod.getPath());
                        int distance=nod.getLevel();
                        NodA child = new NodA(p3, "left",path,distance+1);
                        child.addPath(p3);
                        nod.insert(child);
                        q.add(child);
                    }
                }
                if (nod.getLastMove() != "left") {
                    Puzzle copy4 = new Puzzle(puzzle);
                    Puzzle p4 = new Puzzle(copy4.move_right());
                    if (p4.getTablou().length != 0) {
                        List<Puzzle> path=new ArrayList<>(nod.getPath());
                        int distance=nod.getLevel();
                        NodA child = new NodA(p4, "right",path,distance+1);
                        child.addPath(p4);
                        nod.insert(child);
                        q.add(child);
                    }
                }
            }
//            List<Nod> children = new ArrayList<Nod>(nod.getChildren());
//            System.out.println("Dupa adaugare copiii sunt:");
//            for (Nod child : children)
//                child.getPuzzle().showTable();
        }
    }
    public static void main(String[] args)
    {
        int[][] table = new int[][]{
                { 3,0,2},
                { 6,5,1 },
                {4,7,8}
        };
        int[][] Final = new int[][]{
                { 1, 2,3},
                { 4, 5,6},
                {7,8,0}
        };
        Pairr<Integer,Integer> empty_indexes=new Pairr<Integer,Integer>(0,1);
        Puzzle puzzle=new Puzzle(table,empty_indexes);
        System.out.println("Acesta este Puzzle ul de inceput:");
        puzzle.showTable();

        System.out.println("Vrem sa ajungem la:");
        for(int i=0;i<Final.length;i++)
        {
            for(int j=0;j<Final.length;j++)
            {
                if(Final[i][j]==0)
                    System.out.print("s ");
                else
                    System.out.print(Final[i][j]+" ");
            }
            System.out.println();
        }

        List<Puzzle> path=new ArrayList<>();
        path.add(puzzle);
        NodA nod = new NodA(puzzle,"",path,0);
        solve(nod,Final);
    }
}
