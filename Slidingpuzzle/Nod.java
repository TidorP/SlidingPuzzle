package vac.Slidingpuzzle;

import java.util.ArrayList;
import java.util.List;

public class Nod {
    private Puzzle val;
    private List<Nod> children;
    private String lastMove;
    private List<Puzzle> path;
    public Nod(Puzzle value,String lM,List<Puzzle> path) {
        this.val = value;
        this.children=new ArrayList<>();
        this.lastMove=lM;
        this.path=path;
    }
    public void insert(Nod child)
    {
        this.children.add(child);
    }

    public Puzzle getPuzzle() {
        return val;
    }

    public List<Nod> getChildren() {
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

}
