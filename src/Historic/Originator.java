package Historic;

public class Originator
{
	private Memento state;
 
    public void set_mem(Memento state) {
        this.state = state;
    }
 
    public Memento saveToMemento() {
        return state;
    }
 
    public void restoreFromMemento(Memento memento) {
        state = memento.getSavedState();
    }
 
}
