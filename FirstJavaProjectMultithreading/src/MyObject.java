
public class MyObject
{
    private /*volatile*/ static int _x = 0;

    /****************************************************/

    public MyObject(int num)
    {
        this._x = num;
    }

    public MyObject()
    {
        this(0);
    }
    /****************************************************/

    /**
     * Increment the value of _x, by one.
     */
    public void increment()
    {
        this._x++;
        //System.out.print(" |_x :" + this._x + "|");
        //this._x = this._x + 1;
    }

    /**
     * Decrement the value of _x, by one.
     */
    public void decrement()
    {
        //_x = _x - 1;
        //System.out.print(" |_x :" + this._x + "|");
        this._x--;
    }

    /**
     *
     * @return the current value of _x.
     */
    public int getValue()
    {
        return this._x;
    }
}