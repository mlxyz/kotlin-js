import kotlin.browser.*
import kotlinx.html.*
import kotlinx.html.dom.*
import org.w3c.xhr.XMLHttpRequest

fun main(args: Array<String>) {
    println("Hello JavaScript!")

    println("Getting data from REST webservice")

    val request = XMLHttpRequest()
    request.addEventListener("load",callback = {
        val json = request.responseText
        println("Got data: ")
        println(json)
        val list = JSON.parse<Array<Post>>(json).toList()

        for(post in list)
        {
            document.body!!.append.div {
                h1 {
                    +"${post.id}: ${post.title} from \"${post.userId}\""
                }
                span {
                    +post.body
                }
            }

        }




    })
    request.open("GET","https://jsonplaceholder.typicode.com/posts")
    request.send()
}