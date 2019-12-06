package com.作业;
import java.util.*;
/**
 * 
 * @author 王荣华
 *
 */
public class Test1_2 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Fen fs=new Fen();
		System.out.println("最后成绩："+fs.getavgFen());
		System.out.println("最差的评委："+fs.getchaIndex());
		System.out.println("最佳的评委："+fs.gethaoIndex());

	}

}
//定义一个成绩管理系统
class Fen {
	private int size=4;
	float arr[]=null;
	public Fen() {
		arr=new float[size];
		Scanner q=new Scanner(System.in);
		try {
			for(int i=0;i<arr.length;i++){
				System.out.print("请输入第"+(i+1)+"评委的成绩:");
				arr[i]=q.nextFloat();
			}
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println("输入错误:"+e.getMessage());
		}	
    }
	//最后的成绩
	public float getavgFen(){
		float sunFen=0;
		for(int i=0;i<arr.length;i++){
			if(i!=this.getmaxFenIndex()&&i!=this.getminFenIndex()){
				sunFen+=arr[i];
			}
		}
		return sunFen/(arr.length-2);
	}
	//最差的评委
	public int getchaIndex(){
		float avg=this.getavgFen();
		float cha=Math.abs(arr[0]-avg);
		int chaIndex=0;
		for(int i=0;i<arr.length;i++){
			float tmp=Math.abs(arr[i]-avg);
			if(cha<Math.abs(arr[i]-avg)){
				cha=tmp;
				chaIndex=i;
			}
		}
		return chaIndex+1;
	}
	//最佳的评委
	public int gethaoIndex(){
		float avg=this.getavgFen();
		float hao=Math.abs(arr[0]-avg);
		int haoIndex=0;
		for(int i=0;i<arr.length;i++){
			float tmp=Math.abs(arr[i]-avg);
			if(hao>tmp){
				hao=tmp;
				haoIndex=i;
			}
		}
		return haoIndex+1;
	}
	//最高分下标
	public int getmaxFenIndex(){
		float max=arr[0];
		int maxIndex=0;
		for(int i=0;i<arr.length;i++){
			if(max>arr[i]){
				max=arr[i];
				maxIndex=i;
			}
		}
		return maxIndex;
	}
	//最低分下标
	public int getminFenIndex(){
		float min=arr[0];
		int minIndex=0;
		for(int i=0;i<arr.length;i++){
			if(min<arr[i]){
				min=arr[i];
				minIndex=i;
			}
		}
		return minIndex;
	}
}