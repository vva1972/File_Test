package ru.buhsoft.filetest

import android.R
import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.os.Environment
import android.text.TextUtils
import android.util.Log
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import org.xmlpull.v1.XmlPullParser
import org.xmlpull.v1.XmlPullParserFactory
import ru.buhsoft.filetest.databinding.ActivityMainBinding
import java.io.*


class MainActivity : AppCompatActivity() {

    private lateinit var mBinding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        mBinding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(mBinding.root)

        mBinding.button.setOnClickListener {
            val path =
                Environment.getExternalStorageDirectory().toString() + "/" + "Downloads" + "/"
            val uri = Uri.parse(path)
            val intent = Intent(Intent.ACTION_GET_CONTENT)
            intent.setDataAndType(uri, "*/*")
            startActivityForResult(Intent.createChooser(intent, "Select a file"), 111)
        }
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        if (requestCode === 111 && resultCode === RESULT_OK) {
            val selectedFile = data?.data //The uri with the location of the file
            //The uri with the location of the file
            val path = selectedFile?.path
            Log.d("vva: ", "path: " + path)
            val fileName = path?.substring(path.lastIndexOf(":") + 1)
            Log.d("vva: ", "File name: " + fileName)

//            Log.d("vva: ", "selectedFile.toString " + selectedFile.toString())
//            Log.d("vva: ", "selectedFile?.path " + selectedFile?.path.toString())

//            val file = File("/storage/emulated/0/Download/Cheque.xml")
            //val file = File(fileName.toString())
            val file = File("/storage/emulated/0/Download/Cheque.xml")
//            Log.d("vva: ", "file $file")

//            Log.d("vva: ", "filefile ${Environment.getExternalStorageDirectory()}")
            val fis = FileInputStream(file)
////////////////////////////////////////////
            // из файла на SD-карты
///            //factory.setNamespaceAware(true); // если используется пространство имён
//            val parser = factory.newPullParser()
//            parser.setInput(InputStreamReader(fis));
//            while (parser.eventType != XmlPullParser.END_DOCUMENT) {
//                val tagname = parser.name
//                Log.d("vva: ", "tagname $tagname")
//                parser.next()
//            }

/*
            ////////////////////////////////////////////////////////////////////////
            try {
//                val parser: XmlPullParser = resources.getXml(R.xml.contacts)
                val factory = XmlPullParserFactory.newInstance()
                val parser = factory.newPullParser()
                parser.setInput(InputStreamReader(fis));

                while (parser.eventType != XmlPullParser.END_DOCUMENT) {
                    val TAG = "vva"
                    var tmp = ""
                    when (parser.eventType) {
                        XmlPullParser.START_DOCUMENT -> Log.d(TAG, "Начало документа")
                        XmlPullParser.START_TAG -> {
                            Log.d(
                                TAG,
                                "START_TAG: имя тега = " + parser.name
                                        + ", уровень = " + parser.depth
                                        + ", число атрибутов = "
                                        + parser.attributeCount
                            )
                            tmp = ""
                            var i = 0
                            while (i < parser.attributeCount) {
                                tmp = (tmp + parser.getAttributeName(i) + " = "
                                        + parser.getAttributeValue(i) + ", ")
                                i++
                            }
                            if (!TextUtils.isEmpty(tmp)) Log.d(TAG, "Атрибуты: $tmp")
                        }
                        XmlPullParser.END_TAG -> Log.d(TAG, "END_TAG: имя тега = " + parser.name)
                        XmlPullParser.TEXT -> Log.d(TAG, "текст = " + parser.text)
                        else -> {}
                    }
                    parser.next()
                }
            } catch (t: Throwable) {
                Toast.makeText(
                    this,
                    "Ошибка при загрузке XML-документа: $t",
                    Toast.LENGTH_LONG
                ).show()
            }

*/


            try {
//                val parser: XmlPullParser = resources.getXml(R.xml.contacts)
                val factory = XmlPullParserFactory.newInstance()
                val parser = factory.newPullParser()
                parser.setInput(InputStreamReader(fis));

                while (parser.eventType != XmlPullParser.END_DOCUMENT) {
                    val TAG = "vva"
                    var tmp = ""
                    when (parser.eventType) {
                        XmlPullParser.START_DOCUMENT -> Log.d(TAG, "Начало документа")
                        XmlPullParser.START_TAG -> {
                            Log.d(
                                TAG,
                                "START_TAG: имя тега = " + parser.name
                                        + ", уровень = " + parser.depth
                                        + ", число атрибутов = "
                                        + parser.attributeCount
                            )
                            tmp = ""
                            var i = 0
                            while (i < parser.attributeCount) {
                                tmp = (tmp + parser.getAttributeName(i) + " = "
                                        + parser.getAttributeValue(i) + ", ")
                                i++
                            }
                            if (!TextUtils.isEmpty(tmp)) Log.d(TAG, "Атрибуты: $tmp")
                        }
                        XmlPullParser.END_TAG -> Log.d(TAG, "END_TAG: имя тега = " + parser.name)
                        XmlPullParser.TEXT -> Log.d(TAG, "текст = " + parser.text)
                        else -> {}
                    }
                    parser.next()
                }
            } catch (t: Throwable) {
                Toast.makeText(
                    this,
                    "Ошибка при загрузке XML-документа: $t",
                    Toast.LENGTH_LONG
                ).show()
            }



        }
    }
}