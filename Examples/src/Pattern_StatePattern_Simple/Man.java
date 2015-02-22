package Pattern_StatePattern_Simple;
/*
 * ��һ����A��ĳ����Ա������ֵ�仯ʱ�����ܵ��¶����Ϊ���ֵò�ͬ�����ó�Ա������װ�����͵�ģʽ����Ϊ״̬ģʽ��state pattern����
   ��̼��ɣ��Զ�̬���ع���֧�ṹ�� => �����µ�״ֵ̬���ڷ�֧�ṹ��Υ��OCP��
   ���˼·�����״̬��ӡ�״̬ת����״̬����Ϊ��Ӱ�����⡣
   �ع���Ҫ�㣺
   1.��״̬��State���boolean��int��ö�����ͻ�����(ע���������)�ķ�֧�жϲ�������Ȼ�ж��ٷ�֧��State����Ӧ�ж������ࡣ
   2.״̬��State�����о���������֧�жϵķ�������ȡΪ�Լ��Ľӿڣ�State������ֱ�������׵�ʵ�֡�

 */
public class Man {
	private State state;
	
	public Man(State s){
		state = s;
	}
	public String sayHello() {
        return state.sayHello();
    }
    public String sayGoodbye() {
        return state.sayGoodbye();      
    }
    
    public static void main(String[] args) {
		Man one = new Man( new FriendState() );// ���� State�Ķ������� �ı���״̬
		System.out.println(one.sayHello());
		System.out.println(one.sayGoodbye());
	}
}