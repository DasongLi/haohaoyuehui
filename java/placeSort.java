package com.example.pro.test1;

public class placeSort {
	private int total;
	private int shanghai;
	private int zhejiang;
	public Place[] allPlace;
	
	public placeSort( Place[] places )
	{
		total = places.length;
		allPlace = new Place[total];
		int shC = 0, zjC = 0;
		for(int i = 0; i < total; ++i)
		{
			allPlace[i] = places[i];
			if(places[i].city == "Shanghai") shC++;
			else if(places[i].city == "Zhejiang") zjC++;
		}
		
		shanghai = shC;
		zhejiang = zjC;
	}
	
	public static int partition(Place []array,int lo,int hi, int charType){
        //固定的切分方式
        Place key=array[lo];
        while(lo<hi){
            while(array[hi].weight[charType]<=key.weight[charType] && hi>lo){//从后半部分向前扫描
                hi--;
            }
            array[lo]=array[hi];
            while(array[lo].weight[charType]>key.weight[charType]&&hi>lo){//从前半部分向后扫描
                lo++;
            }
            array[hi]=array[lo];
        }
        array[hi]=key;
        return hi;
    }
    
    public static void sort(Place[] array,int lo ,int hi, int charType){
        if(lo>=hi){
            return ;
        }
        int index=partition(array,lo,hi, charType);
        sort(array,lo,index-1, charType);
        sort(array,index+1,hi,charType); 
    }
	
	public Place[] allSort(int charType)
	{
		Place[] alllist = new Place[total];
		
		for(int i = 0; i<total; i++) alllist[i] = allPlace[i];
		
		sort(alllist,0,total-1,charType);
		return alllist;
	}
	
	public Place[] zhejiangSort(int charType)
	{
		Place[] zhejianglist = new Place[zhejiang];
		
		for(int i = 0; i<zhejiang; i++) zhejianglist[i] = allPlace[i];
		
		sort(zhejianglist,0,zhejiang-1,charType);
		return zhejianglist;
	}

	public Place[] shanghaiSort(int charType)
	{
		Place[] shanghailist = new Place[shanghai];
		
		for(int i = zhejiang; i<zhejiang+shanghai; i++) shanghailist[i-shanghai] = allPlace[i];
		
		sort(shanghailist,0,shanghai-1, charType);
		return shanghailist;
	}
	
	
}
