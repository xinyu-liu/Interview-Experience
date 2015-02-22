package Pattern_StatePattern_FiniteStateMachine_WithEnum;

public enum State {
	/** 
	 * 本来是应该将State1作为Aircon1的内部类的。现在放在外边， 
	 * power()等需要变为power(AirCon ac) 
	 */  
	
	OFF{
		// 状态模式 提取的接口 
		@Override public void power(AirCon ac){
			this.exitState(ac);
            //如果有的话，事件(event)相应的动作
			this.startFan();
			//下一个状态
			ac.state = FANONLY;
			this.enterState(ac);
		};
		@Override public void cool(AirCon ac){
			System.out.println("nothing");
		}
	},
	FANONLY{
		// 状态模式 提取的接口 
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
		// 状态模式 提取的接口 
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
	// 状态模式 提取的接口  
	// (本来是应该将State1作为Aircon的内部类的。放在外边，power()等需要添加参数Aircon，变为power(Aircon ac)).
	abstract public void power(AirCon ac);
	abstract public void cool(AirCon ac);
	
	//状态机的各种动作显示（打印）action method  -> 增添动作(action)，如事件(event)相应的动作和状态的动作。
    void enterState(AirCon ac){System.out.println(" →"+ac.state.name());}  
    void exitState(AirCon ac){System.out.print(ac.state.name()+"→ ");}  
    // actions
    void startCool(){ System.out.print("start Cool");    }  
    void stopCool(){  System.out.print("stop Cool");    }  
    void startFan(){  System.out.print("start Fan");    }  
    void stopFan(){   System.out.print("stop Fan");    }   
}
