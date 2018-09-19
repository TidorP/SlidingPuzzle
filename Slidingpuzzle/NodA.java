package vac.Slidingpuzzle;

import java.util.ArrayList;
import java.util.List;

public class NodA {
    private Puzzle val;
    private List<NodA> children;
    private String lastMove;
    private List<Puzzle> path;
    private int level;
    public NodA(Puzzle value,String lM,List<Puzzle> path,int level) {
        this.val = value;
        this.children=new ArrayList<>();
        this.lastMove=lM;
        this.path=path;
        this.level=level;
    }
    public void insert(NodA child)
    {
        this.children.add(child);
    }

    public Puzzle getPuzzle() {
        return val;
    }

    public List<NodA> getChildren() {
        return children;
    }

    public String getLastMove() {
        return lastMove;
    }

    public List<Puzzle> getPath() {
        return path;
    }
    public List<Puzzle> addPath(Puzzle p)
    {
        this.path.add(p);
        return this.path;
    }

    public int getLevel() {
        return level;
    }
}


