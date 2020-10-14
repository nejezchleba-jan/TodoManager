package tma.inf.upol.cz

import android.app.Activity
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuInflater
import android.view.MenuItem
import android.widget.*
import tma.inf.upol.cz.Models.TodoItem

class MainActivity : AppCompatActivity() {
    companion object {
        const val REQUEST_EDIT: Int = 1
        const val REQUEST_EDIT_OK: Int = 0
        const val TITLE = "TITLE";
        const val CONTENT = "CONTENT"
        const val ID = "ID"
    }

    private var todoList: MutableList<TodoItem> = mutableListOf<TodoItem>()
    private lateinit var todoAdapter: ArrayAdapter<TodoItem>

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        super.onCreateOptionsMenu(menu)
        val inflater: MenuInflater = menuInflater
        inflater.inflate(R.menu.main_menu, menu);
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when(item.itemId) {
            R.id.insert_todo -> addItem()
        }
        return false;
    }

    private fun addItem() {
        val i = Intent(this, InsertActivity::class.java)
        i.putExtra(ID, -1)
        startActivityForResult(i, REQUEST_EDIT)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        todoAdapter = ArrayAdapter(this, R.layout.todo_item, R.id.text, todoList)

        val todoListView: ListView = findViewById(R.id.todoList)
        val btnHello: Button = findViewById(R.id.btnHello)

        todoListView.adapter = todoAdapter

       /* btnInsert.setOnClickListener{ v ->
            val i = Intent(this, InsertActivity::class.java)
            i.putExtra(ID, -1)
            startActivityForResult(i, REQUEST_EDIT)
        }*/

        btnHello.setOnClickListener {
            val i = Intent(this, ActivitySecond::class.java)
            startActivity(i)
        }

        todoListView.setOnItemClickListener {parent, view, position, id ->
            val i = Intent(this, InsertActivity::class.java)
            i.putExtra(TITLE,todoList[position].getTitle())
            i.putExtra(CONTENT,todoList[position].getContent())
            i.putExtra(ID, position)
            startActivityForResult(i, REQUEST_EDIT)
        }

    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        if(requestCode == REQUEST_EDIT) {
            if(resultCode == REQUEST_EDIT_OK){

                val itemId = data?.getIntExtra("ID", -1)!!
                val itemTitle = data?.getStringExtra("TITLE")!!
                val itemContent = data?.getStringExtra("CONTENT")!!

                if(itemId == -1){
                    todoAdapter.add(TodoItem(itemTitle, itemContent))
                } else {
                    todoList[itemId].setTitle(itemTitle)
                    todoList[itemId].setContent(itemContent)
                }

                todoAdapter.notifyDataSetChanged()
            }
        }
    }
}
