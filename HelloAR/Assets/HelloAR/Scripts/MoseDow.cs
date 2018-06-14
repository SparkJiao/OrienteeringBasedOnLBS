using System.Collections;
using System.Collections.Generic;
using UnityEngine.SceneManagement;
using UnityEngine;

public class MoseDow : MonoBehaviour {

	bool flag = true;

	// Use this for initialization
	void Start () {
		
	}
	
	// Update is called once per frame
	void Update () {
		
	}

	void OnMouseDown(){
		//Application.LoadLevel
		SceneManager.LoadScene("CaveGeneration 3D");
	}

	void OnGUI(){
		
	}
}
