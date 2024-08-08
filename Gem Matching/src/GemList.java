public class GemList 
{
	Node head;
	int size;
	final int maxGems = 16;
	public GemList() {
		head = null;
	}
	public int size() {
		return size;
	}
	public void draw(double y) {
		Node temp = head;
		int i =0;
		while(temp!=null) {
			temp.gem.draw(GemGame.indexToX(i), y);
			temp=temp.next;
			i++;
		}
	}
	@Override
	public String toString() {
		return "size = " + size() + ", score = " + score();
	}
	public void insertBefore(Gem gem, int index) {
		if(index>size) {
			index = size;
		}
		if(index==0) {
			head = new Node(gem);
			size++;
			return;
		}
		System.out.println(index);
		Node temp = head;
		Node previous = head;
		int counter = 0;
		while(counter != index) {
			previous = temp;
			temp = temp.next;
			counter++;
		}
		previous.next = new Node(gem);
		previous = previous.next;
		previous.next = temp;
		size++;
		
	}
	public int score(){
		int score = 0;
		Node temp = head;
		int tempScore = 0;
		int multipler = 1;
		while(temp!=null) {
			tempScore += temp.gem.getPoints();
			if(temp.next!=null && temp.gem.getType() == temp.next.gem.getType()) {
				multipler++;
			}else {
				score += (multipler * tempScore);
				tempScore = 0;
				multipler = 1;
			}
			temp = temp.next;
		}
		return score;
	}
	
	private class Node{
		private Gem gem;
		private Node next;
		public Node(Gem val) {
			gem = val;
		}
	}
	
	public static void main(String [] args)
	{
		GemList list = new GemList();
		System.out.println(list);
		System.out.println("size = " + list.size() + ", score = " + list.score());
		list.draw(0.9);		
		
		list.insertBefore(new Gem(GemType.BLUE, 10), 0);
		System.out.println("\n" + list);
		System.out.println("size = " + list.size() + ", score = " + list.score());
		list.draw(0.8);
		
		list.insertBefore(new Gem(GemType.BLUE, 20), 99);  //not a mistake, should still work
		System.out.println("\n" + list);
		System.out.println("size = " + list.size() + ", score = " + list.score());
		list.draw(0.7);
		
		list.insertBefore(new Gem(GemType.ORANGE, 30), 1);
		System.out.println("\n" + list);
		System.out.println("size = " + list.size() + ", score = " + list.score());
		list.draw(0.6);
//		
		list.insertBefore(new Gem(GemType.ORANGE, 10), 2);
		System.out.println("\n" + list);
		System.out.println("size = " + list.size() + ", score = " + list.score());
		list.draw(0.5);
		
		list.insertBefore(new Gem(GemType.ORANGE, 50), 3);
		System.out.println("\n" + list);
		System.out.println("size = " + list.size() + ", score = " + list.score());
		list.draw(0.4);
		
		list.insertBefore(new Gem(GemType.GREEN, 50), 2);
		System.out.println("\n" + list);
		System.out.println("size = " + list.size() + ", score = " + list.score());
		list.draw(0.3);		
	}	
}
