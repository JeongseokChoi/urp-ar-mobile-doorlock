using UnityEngine;
using System.Collections;

public class buttonOk : MonoBehaviour {

	// Use this for initialization
	void Start () {

	}

	// Update is called once per frame
	void Update () {

	}

	public void onClick () {
		string tmpstr = "";

		Debug.Log ("button Ok clicked");

		Stack temp = new Stack ();

		while (SetStack.password.Count > 0) {
			temp.Push (SetStack.password.Pop ());
		}

		while (temp.Count > 0) {
			tmpstr += temp.Pop ();
		}

		BtConnector.sendString (tmpstr);
	}
}