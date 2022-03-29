import java.util.ArrayList;

public class Cabaret
{
    private String name;
    private ArrayList<Performer> performers;

    public Cabaret(String n)
    {
        name = n;
        performers = new ArrayList<>();
    }

    public String getName()
    {
        return name;
    }

    public ArrayList<Performer> getPerformers()
    {
        return performers;
    }

    public boolean addPerformer(Performer p)
    {
        if (performers.contains(p))
        {
            return false;
        }
        else
        {
            performers.add(p);
            return true;
        }
    }

    public boolean removePerformer(Performer p)
    {
        for (int i = 0; i < performers.size(); i++)
        {
            if (performers.get(i) == p)
            {
                performers.remove(i);
                return true;
            }
        }
        return false;
    }

    public double averagePerformerAge()
    {
        double counter = 0;
        for (Performer p : performers)
        {
            counter += p.getAge();
        }
        return counter / performers.size();
    }

    public ArrayList<Performer> performersOverAge(int age)
    {
        ArrayList<Performer> overAge = new ArrayList<>();
        for (Performer p : performers)
        {
            if (p.getAge() >= age)
            {
                overAge.add(p);
            }
        }
        return overAge;
    }

    public void groupRehearsal()
    {
        for (Performer p : performers)
        {
            System.out.println("Rehearsal Call! " + p.getName());

            if (p instanceof Comedian)
            {
                Comedian temp = (Comedian) p;
                temp.rehearse(false);
            }
            else
            {
                p.rehearse();
            }
        }
    }

    public void cabaretShow()
    {
        for (Performer p : performers)
        {
            System.out.println("Welcome to the cabaret! Next act up... " + p.getName());

            if (p instanceof Dancer)
            {
                Dancer temp = (Dancer) p;
                temp.pirouette(2);
            }

            p.perform();
        }
    }
}
