

class Nodo implements Comparator<Nodo>

{

    public int erpin;
    public int pisu;

 
 

    public nodo(int e, int p)

    {

        this.erpin = e;

        this.pisu = pisu;

    }

 

    @Override

    public int compare(Node node1, Node node2)

    {

        if (node1.cost < node2.cost)

            return -1;

        if (node1.cost > node2.cost)

            return 1;

        return 0;

    }

}