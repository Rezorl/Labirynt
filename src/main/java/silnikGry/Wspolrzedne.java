package silnikGry;

public class Wspolrzedne {
    private int x;
    private int y;

    public Wspolrzedne(int x, int y)
    {
        this.x=x;
        this.y=y;
    }

    public void setX(int x) {
        this.x = x;
    }

    public void setY(int y) {
        this.y = y;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    @Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + x;
		result = prime * result + y;
		return result;
	}

	@Override
	public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Wspolrzedne that = (Wspolrzedne) o;
        if (x != that.x) return false;
        return y == that.y;
	}

	@Override
	public String toString() {
		return "Wspolrzedne [x=" + x + ", y=" + y + "]";
	}
	
	
}
