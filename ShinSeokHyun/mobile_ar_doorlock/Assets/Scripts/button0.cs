using UnityEngine;
using System.Collections;

public class button0 : MonoBehaviour {

	// Use this for initialization
	void Start () {

	}

	// Update is called once per frame
	void Update () {

	}

	public void onClick () {
		Debug.Log ("button 0 clicked");
		SetStack.password.Push (0);

		int c = SetStack.password.Count;

		manage_text.t.text = "";
		for (int i = 0; i < c; i++) {
			manage_text.t.text += "X";
		}
	}
}