package Pattern_StatePattern_FiniteStateMachine_WithEnum;

public enum State {
	/** 
	 * ������Ӧ�ý�State1��ΪAircon1���ڲ���ġ����ڷ�����ߣ� 
	 * power()����Ҫ��Ϊpower(AirCon ac) 
	 */  
	
	OFF{
		// ״̬ģʽ ��ȡ�Ľӿ� 
		@Override public void power(AirCon ac){
			this.exitState(ac);
            //����еĻ����¼�(event)��Ӧ�Ķ���
			this.startFan();
			//��һ��״̬
			ac.state = FANONLY;
			this.enterState(ac);
		};
		@Override public void cool(AirCon ac){
			System.out.println("nothing");
		}
	},
	FANONLY{
		// ״̬ģʽ ��ȡ�Ľӿ� 
		@Override public void power(AirCon ac){
			this.exitState(ac);
			this.stopFan();
			ac.state = OFF;
			this.enterState(ac);
		};
		@Override public void cool(AirCon ac){
			this.exitState(ac);
			this.startCool();
			ac.state = COOL;
			this.enterState(ac);
		}
	},
	COOL{
		// ״̬ģʽ ��ȡ�Ľӿ� 
		@Override public void power(AirCon ac){
			this.exitState(ac);
			this.stopFan();
			ac.state = OFF;
			this.enterState(ac);
		};
		@Override public void cool(AirCon ac){
			this.exitState(ac);
			this.stopCool();
			ac.state = FANONLY;
			this.enterState(ac);
		}
	};
	// ״̬ģʽ ��ȡ�Ľӿ�  
	// (������Ӧ�ý�State1��ΪAircon���ڲ���ġ�������ߣ�power()����Ҫ��Ӳ���Aircon����Ϊpower(Aircon ac)).
	abstract public void power(AirCon ac);
	abstract public void cool(AirCon ac);
	
	//״̬���ĸ��ֶ�����ʾ����ӡ��action method  -> ������(action)�����¼�(event)��Ӧ�Ķ�����״̬�Ķ�����
    void enterState(AirCon ac){System.out.println(" ��"+ac.state.name());}  
    void exitState(AirCon ac){System.out.print(ac.state.name()+"�� ");}  
    // actions
    void startCool(){ System.out.print("start Cool");    }  
    void stopCool(){  System.out.print("stop Cool");    }  
    void startFan(){  System.out.print("start Fan");    }  
    void stopFan(){   System.out.print("stop Fan");    }   
}
