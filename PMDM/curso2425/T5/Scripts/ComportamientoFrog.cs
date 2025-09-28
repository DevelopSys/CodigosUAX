using TMPro;
using UnityEditor.Callbacks;
using UnityEditor.SearchService;
using UnityEngine;
using UnityEngine.SceneManagement;

public class ComportamientoFrog : MonoBehaviour
{
    // Start is called once before the first execution of Update after the MonoBehaviour is created
    // puedo tener todas las caracteristicas que tiene el objeto donde esta aplicado el script -> Frog
    public float velocidad = 0.1f;
    private Rigidbody2D rg;
    private SpriteRenderer sp;
    private Animator animator;
    private bool saltar = false;
    private int puntos = 0;
    private int vidas = 5;

    public TMP_Text textoVidas;

    void Start()
    {
        // inicializaciones
        Debug.Log("Metodo ejecutado desde el Start");
        rg = gameObject.GetComponent<Rigidbody2D>();
        sp = gameObject.GetComponent<SpriteRenderer>();
        animator = gameObject.GetComponent<Animator>();

    }

    // Update is called once per frame
    void Update()
    {
        textoVidas.text = vidas.ToString();
        // logicos
        Debug.Log("Metodo ejecutado desde el Update");
        if (puntos == 5)
        {
            SceneManager.LoadScene(0);
        }

    }

    public void SetVidas(int vidas)
    {
        this.vidas -= vidas;
    }
    public int GetVidas()
    {
        return this.vidas;
    }

    /// This function is called every fixed framerate frame, if the MonoBehaviour is enabled.
    void FixedUpdate()
    {
        // ejecuciones graficas -> movimientos   

        if (Input.GetKey("a"))
        {
            Debug.Log("Pulsado izquierda");
            gameObject.transform.position = new Vector2(gameObject.transform.position.x - velocidad, gameObject.transform.position.y);
            sp.flipX = true;
            animator.SetBool("correr", true);

        }
        else if (Input.GetKey("d"))
        {
            Debug.Log("Pulsado derecha");
            gameObject.transform.position = new Vector2(gameObject.transform.position.x + velocidad, gameObject.transform.position.y);
            sp.flipX = false;
            animator.SetBool("correr", true);
        }
        else
        {
            animator.SetBool("correr", false);
        }

        if (Input.GetKey("w"))
        {

            Debug.Log("Pulsado salto");
            gameObject.transform.position = new Vector2(gameObject.transform.position.x, gameObject.transform.position.y + velocidad);
            saltar = true;
            animator.SetBool("saltar", saltar);
            // rg. AddForce(new Vector2(gameObject.transform.position.x, gameObject.transform.position.y * 0.5f));
        }

        animator.SetBool("saltar", saltar);
        // animator.SetBool("saltar", false);
        // animator.SetBool("correr", false);



    }

    /// <summary>
    /// Sent when an incoming collider makes contact with this object's
    /// collider (2D physics only).
    /// </summary>
    /// <param name="other">The Collision2D data associated with this collision.</param>
    void OnCollisionEnter2D(Collision2D other)
    {
        if (other.collider.tag == "Ground")
        {
            saltar = false;
        }
    }

    /// <summary>
    /// Sent when a collider on another object stops touching this
    /// object's collider (2D physics only).
    /// </summary>
    /// <param name="other">The Collision2D data associated with this collision.</param>
    void OnCollisionExit2D(Collision2D other)
    {
        if (other.collider.tag == "Ground")
        {
            saltar = true;
        }
    }

    /// <summary>
    /// Sent when another object enters a trigger collider attached to this
    /// object (2D physics only).
    /// </summary>
    /// <param name="other">The other Collider2D involved in this collision.</param>
    void OnTriggerEnter2D(Collider2D other)
    {
        if (other.gameObject.tag == "Fruit")
        {
            puntos += 1;
            Debug.Log("Punto recoletado = " + puntos);
        }
    }

}
