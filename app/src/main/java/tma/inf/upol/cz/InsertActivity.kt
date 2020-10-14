package tma.inf.upol.cz

import android.app.Activity
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.EditText

class InsertActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_insert)

        val btnOk: Button = findViewById(R.id.btnOk)
        val editTit: EditText = findViewById(R.id.editTit)
        val editObsah: EditText = findViewById(R.id.editObsah)

        if(intent.getStringExtra(MainActivity.TITLE) != null){
            editTit.setText(intent.getStringExtra(MainActivity.TITLE))
        }

        if(intent.getStringExtra(MainActivity.CONTENT) != null){
            editObsah.setText(intent.getStringExtra(MainActivity.CONTENT))
        }


        btnOk.setOnClickListener{ v ->

            var resultData: Intent = Intent()
            resultData.putExtra(MainActivity.TITLE, editTit.text.toString())
            resultData.putExtra(MainActivity.CONTENT, editObsah.text.toString())
            resultData.putExtra(MainActivity.ID, intent.getIntExtra(MainActivity.ID, -1))
            setResult(MainActivity.REQUEST_EDIT_OK, resultData)
            finish()
        }

    }


}
