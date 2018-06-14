using System.Collections;
using System.Collections.Generic;
using UnityEngine;

public class Tuoka : MonoBehaviour {

	public GameObject Target;//卡片  
	public GameObject zhen;//识别图上的模型  
	public GameObject zhen2;//相机下的模型  
	bool firstFound = false;//是否是第一次识别  

	void Start()  
	{  
		zhen.SetActive(false);  
		zhen2.SetActive(false);  
		firstFound = false;
	}  
	void Update()  
	{  
		if (Target.activeSelf == true)  
		{  
			zhen.SetActive(true);  
			zhen2.SetActive(false);//不显示脱卡状态的模型  
			//zhen2.transform.GetComponent<Animation>().Stop("Take 001");//停止脱卡状态下模型的动画  
			//zhen.GetComponent<Animation>().Stop("Take 001");//识别图上的模型不播放动画  
			firstFound = true;

		}  
		if (Target.activeSelf == false && firstFound == true)
		{  
			zhen.SetActive(false);  
			zhen2.SetActive(true);//显示模型  
			//zhen2.transform.GetComponent<Animation>().Play("Take 001");  
		}
	}
}
