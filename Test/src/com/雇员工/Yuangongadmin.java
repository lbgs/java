package com.��Ա��;
/**
 * 
 * @author ���ٻ�
 *
 */
import java.util.*;
public class Yuangongadmin {
	ArrayList ll;
	public Yuangongadmin(){
		ll=new ArrayList();
	}
	//1�����һ��Ա��
	public void addEmp(Yuangong emp){
        ll.add(emp);
        System.out.println("��ӳɹ�");
	}
	//2���鿴һ��Ա����Ϣ
	public void showinfo(String empNo){
		//��������ArrayList
		for(int i=0;i<ll.size();i++){
			//ȡ��Yuangong����
			Yuangong emp=(Yuangong)ll.get(i);
			if(emp.getEmpNO().equals(empNo)){
				System.out.println("Ա����Ϣ��" );
				System.out.println("Ա����ţ�"+empNo);
				System.out.println("Ա��������"+emp.getName());
				System.out.println("Ա�����ʣ�"+emp.getSal());			}
		}
	}
    //3���鿴����Ա������Ϣ
	public void show(){
		System.out.println("Ա�����"+"\tԱ������"+"\tԱ������");
		for(int i=0;i<ll.size();i++){
			Yuangong emp=(Yuangong)ll.get(i);
			System.out.println(emp.getEmpNO()+"\t"+emp.getName()+"\t"+emp.getSal());
		}
	}
    //4���޸�ָ��Ա������
	public void update(String empNo,float sal){
		for(int i=0;i<ll.size();i++){
			Yuangong emp=(Yuangong)ll.get(i);
			if(emp.getEmpNO().equals(empNo)){
				emp.setSal(sal);
				System.out.println("�޸ĳɹ�");
			}
		}
	}
	//5��ɾ��ָ��Ա��
	public void delEmp(String empNo){
		for(int i=0;i<ll.size();i++){
			Yuangong emp=(Yuangong)ll.get(i);
			if(emp.getEmpNO().equals(empNo)){
				ll.remove(i);
				System.out.println("ɾ���ɹ�");
			}
		}
	}
    //6�������ʴӵ͵�������
	public void srto(Yuangong arr[]){
	    int tmp;
	    for(int i=0;i<arr.length-1;i++){
	    	float min=arr[i].getSal();
	    	int w=i;
	    	for(int j=0;j<arr.length;j++){
	    		if(min<arr[j].getSal()){
	    			min=arr[j].getSal();
	    			w=j;
	    		}
	    	}
	    	System.out.println(min);
	    }
	}
	//7��ͳ��ƽ�����ʡ���͹��ʡ���߹���
	public void avg(){
		float sun=0;
		Yuangong emp=(Yuangong)ll.get(0);
		float max=emp.getSal();
		float min=emp.getSal();
		for(int i=0;i<ll.size();i++){
			emp=(Yuangong)ll.get(i);
			sun+=emp.getSal();
			if(max>emp.getSal()){
				max=emp.getSal();
			}
			if(min<emp.getSal()){
				min=emp.getSal();
			}
		}
		System.out.println("ƽ�����ʣ�"+(sun/ll.size()));
		System.out.println("��߹��ʣ�"+max);
		System.out.println("ƽ�����ʣ�"+min);
	}
}
