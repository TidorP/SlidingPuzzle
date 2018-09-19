package vac.Slidingpuzzle;

import vac.Pairr;

public class Puzzle implements Cloneable{
    private int[][] tablou;
    private Pairr<Integer,Integer> empty_indexes;

    public Puzzle(int[][] tablou, Pairr<Integer, Integer> empty_indexes) {
        this.tablou = tablou;
        this.empty_indexes = empty_indexes;
    }
    public Puzzle(Puzzle ot)
    {
        if(ot==null)
        {
            this.tablou=new int[0][0];
            this.empty_indexes = new Pairr<>(1, 1);
        }
        else {
            this.tablou = new int[ot.getTablou().length][ot.getTablou().length];
            for (int i = 0; i < ot.getTablou().length; i++) {
                System.arraycopy(ot.getTablou()[i], 0, this.tablou[i], 0, ot.getTablou().length);
            }
            int a = new Integer(ot.getEmpty_indexes().getFirst());
            int b = new Integer(ot.getEmpty_indexes().getSecond());
            this.empty_indexes = new Pairr<>(1, 1);
            this.empty_indexes.setFirst(a);
            this.empty_indexes.setSecond(b);
        }
    }
    private void swap(Pairr<Integer, Integer> first_space,Pairr<Integer, Integer> second_space)
    {
        int aux=tablou[first_space.getFirst()][first_space.getSecond()];
        tablou[first_space.getFirst()][first_space.getSecond()]=tablou[second_space.getFirst()][second_space.getSecond()];
        tablou[second_space.getFirst()][second_space.getSecond()]=aux;
    }
    public Puzzle move_up()
    {
        if(empty_indexes.getFirst()==0)
            return null;
        else
        {
            Pairr<Integer, Integer> first_space=new Pairr<Integer,Integer>(empty_indexes.getFirst()-1,empty_indexes.getSecond());
            swap(first_space,empty_indexes);
            empty_indexes.setFirst(empty_indexes.getFirst()-1);
        }
        return this;
    }
    public Puzzle move_down()
    {
        if(empty_indexes.getFirst()==tablou.length-1)
            return null;
        else
        {
            Pairr<Integer, Integer> first_space=new Pairr<Integer,Integer>(empty_indexes.getFirst()+1,empty_indexes.getSecond());
            swap(first_space,empty_indexes);
            empty_indexes.setFirst(empty_indexes.getFirst()+1);
        }
        return this;
    }
    public Puzzle move_left()
    {
        if(empty_indexes.getSecond()==0)
            return null;
        else
        {
            Pairr<Integer, Integer> first_space=new Pairr<Integer,Integer>(empty_indexes.getFirst(),empty_indexes.getSecond()-1);
            swap(first_space,empty_indexes);
            empty_indexes.setSecond(empty_indexes.getSecond()-1);
        }
        return this;
    }
    public Puzzle move_right()
    {
        if(empty_indexes.getSecond()==tablou.length-1)
            return null;
        else
        {
            Pairr<Integer, Integer> first_space=new Pairr<Integer,Integer>(empty_indexes.getFirst(),empty_indexes.getSecond()+1);
            swap(first_space,empty_indexes);
            empty_indexes.setSecond(empty_indexes.getSecond()+1);
        }
        return this;
    }
    public void showTable()
    {
        for(int i=0;i<tablou.length;i++) {
            for (int j = 0; j < tablou.length; j++)
            {
                if(tablou[i][j]==0)
                    System.out.print("s ");
                else
                    System.out.print(tablou[i][j]+" ");
            }
            System.out.println();
        }
        System.out.println();
    }

    public int[][] getTablou() {
        return tablou;
    }

    public Pairr<Integer, Integer> getEmpty_indexes() {
        return empty_indexes;
    }

    public void setTablou(int[][] tablou) {
        this.tablou = tablou;
    }

    public void setEmpty_indexes(Pairr<Integer, Integer> empty_indexes) {
        this.empty_indexes = empty_indexes;
    }
}
