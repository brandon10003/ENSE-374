public class ListElement {
	
	
	public ListElement next;
        public ListElement prev;
	//private ListEl
	private int data;
	
	
	public ListElement()
	{
		this.next = null;
                this.prev = null;
		this.data = 0;
	}
	
	
	public void setData(int data)
	{
		this.data = data;
	}

	
	public int getData()
	{
		return this.data;
	}  
}
