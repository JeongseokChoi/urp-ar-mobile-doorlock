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
		Debug.Log ("button Ok clicked");

		manage_text.t.text = "";

		Stack temp = new Stack ();

		while (SetStack.password.Count > 0) {
			temp.Push (SetStack.password.Pop ());
		}

		while (temp.Count > 0) {
			manage_text.t.text += temp.Pop ();
		}

		BtConnector.sendString (manage_text.t.text);
	}
}