using UnityEngine;
using System.Collections;

public class Player : MonoBehaviour
{

    Rigidbody rb;
    Vector3 velocity;
	Gyroscope gyro;

	float speed = 50.0f;

    void Start()
    {
        rb = GetComponent<Rigidbody>();
		gyro = Input.gyro;
		gyro.enabled = true;
    }

    void Update()
    {
        //rb.AddForce(new Vector3(Input.GetAxisRaw("Horizontal"), 0, Input.GetAxisRaw("Vertical")).normalized * 20);
    }

    void FixedUpdate()
    {
		rb.MovePosition (rb.position + new Vector3 (gyro.attitude.y, 0, -gyro.attitude.x) * speed * Time.fixedDeltaTime);
    }

	protected void OnGUI()
	{
		GUI.skin.label.fontSize = Screen.width / 40;

		GUILayout.Label("Orientation: " + Screen.orientation);
		GUILayout.Label("input.gyro.attitude: " + Input.gyro.attitude);
		GUILayout.Label("iphone width/font: " + Screen.width + " : " + GUI.skin.label.fontSize);
	}
}