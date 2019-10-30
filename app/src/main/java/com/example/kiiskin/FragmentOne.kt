package com.example.kiiskin

import android.Manifest.permission.CAMERA
import android.Manifest.permission.READ_EXTERNAL_STORAGE
import android.app.Activity
import android.content.Context
import android.content.ContextWrapper
import androidx.fragment.app.Fragment
import android.content.Intent
import android.content.pm.PackageManager
import android.graphics.Bitmap
import android.graphics.BitmapFactory
import android.net.Uri
import android.os.Bundle
import android.os.Environment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.provider.MediaStore
import android.util.Log
import android.widget.Button
import android.widget.ImageView
import android.widget.Toast

import androidx.core.app.ActivityCompat
import androidx.core.content.ContextCompat
import androidx.core.content.ContextCompat.getExternalFilesDirs
import androidx.core.content.FileProvider


import java.io.IOException
import java.util.*
import java.io.File
import java.text.SimpleDateFormat

import kotlinx.android.synthetic.main.fragment_fragment_one.*
import android.util.Log.d as d1


class FragmentOne : Fragment() {

//    lateinit var imageView: ImageView
//    lateinit var captureButton: Button

    val REQUEST_IMAGE_CAPTURE = 1

    val context: Context
    @JvmName("getContext2")
    get() = getContext()!!


    private val PERMISSION_REQUEST_CODE: Int = 101

    private var mCurrentPhotoPath: String? = null

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_fragment_one, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
//        buttonCamera.setOnClickListener {
//            val intent = Intent(MediaStore.ACTION_IMAGE_CAPTURE)
//            startActivity(intent)
//        }
//        imageView = findViewById(R.id.image_view)
//        captureButton = findViewById(R.id.btn_capture)
        btn_capture.setOnClickListener(View.OnClickListener {
            if (checkPersmission()) takePicture() else reqPermission()
        })
    }

    override fun onRequestPermissionsResult(requestCode: Int, permissions: Array<out String>, grantResults: IntArray) {
        when (requestCode) {
            PERMISSION_REQUEST_CODE -> {
                if ((grantResults.isNotEmpty() && grantResults[0] == PackageManager.PERMISSION_GRANTED)
                        && grantResults[1] == PackageManager.PERMISSION_GRANTED) {
                    takePicture()
                } else {
                    Toast.makeText(activity, "Permission Denied", Toast.LENGTH_SHORT).show()
                }
                return
            }
            else -> {
            }
        }
    }

    private fun takePicture() {
        val intent = Intent(MediaStore.ACTION_IMAGE_CAPTURE)
        val file: File = createFile()
        d1("file", file.toString())
        val uri: Uri = FileProvider.getUriForFile(
                context,
                "com.example.android.fileprovider",
                file
        )
        d1("uri", uri.toString())
        intent.putExtra(MediaStore.EXTRA_OUTPUT, uri)
        startActivityForResult(intent, REQUEST_IMAGE_CAPTURE)
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        if (requestCode == REQUEST_IMAGE_CAPTURE && resultCode == Activity.RESULT_OK) {
            //To get the File for further usage
            val auxFile = File(mCurrentPhotoPath)
            var bitmap: Bitmap = BitmapFactory.decodeFile(mCurrentPhotoPath)
            image_view.setImageBitmap(bitmap)
        }
    }
    private fun checkPersmission(): Boolean {
        return (ContextCompat.checkSelfPermission(context, android.Manifest.permission.CAMERA) ==
                PackageManager.PERMISSION_GRANTED && ContextCompat.checkSelfPermission(context,
                android.Manifest.permission.READ_EXTERNAL_STORAGE) == PackageManager.PERMISSION_GRANTED)
    }

    private fun reqPermission() {
        requestPermissions(arrayOf(READ_EXTERNAL_STORAGE, CAMERA), PERMISSION_REQUEST_CODE);
    }

    @Throws(IOException::class)
    private fun createFile(): File {
        // Create an image file name
        val timeStamp: String = SimpleDateFormat("yyyyMMdd_HHmmss").format(Date())

//        var cw : ContextWrapper =  ContextWrapper(get)
//        val storageDir: File = Environment.getExternalFileDirectory(Environment.DIRECTORY_PICTURES)
//        val storageDir = context.getExternalFilesDir(Environment.DIRECTORY_PICTURES)
        val storageDir = context.getExternalFilesDir(Environment.DIRECTORY_PICTURES)

        d1("ddd", storageDir.toString())
//        val abc = "/Storage/Download"
//        val storageDir: File = File(abc)
        return File.createTempFile(
                "JPEG_${timeStamp}_", /* prefix */
                ".jpg", /* suffix */
                storageDir /* directory */
        ).apply {
            // Save a file: path for use with ACTION_VIEW intents
            mCurrentPhotoPath = absolutePath
        }
    }

}


//
//        buttonGallery.setOnClickListener {
//            dispatchGalleryIntent()
//        }



//    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
//        if (requestCode == TAKE_PICTURE && resultCode == Activity.RESULT_OK){
//            try {
//                val file = File(currentPath)
//                val url = Uri.fromFile(file)
//                imageView.setImageURI(url)
//            }
//            catch (e: IOException){
//                e.printStackTrace()
//            }
//        }
//        if (requestCode == SELECT_PICTURE && resultCode == Activity.RESULT_OK){
//            try {
//                val uri = data!!.data
//                imageView.setImageURI(uri)
//            }
//            catch (e: IOException){
//                e.printStackTrace()
//            }
//        }
//    }
//
//    fun dispatchGalleryIntent(){
//        val intent = Intent()
//        intent.type = "image/+"
//        intent.action = Intent.ACTION_GET_CONTENT
//        startActivityForResult(Intent.createChooser(intent, "Select image"), SELECT_PICTURE)
//    }
//
//    fun dispatchCameraIntent(){
//            var intent = Intent(MediaStore.ACTION_IMAGE_CAPTURE)
//            if (intent.resolveActivity(PackageManager) != null){
//                var photoFile: File? = null
//                try{
//                    photoFile = createImage()
//                }catch (e: IOException){
//                    e.printStackTrace()
//                }
//                if (photoFile != null) {
//                    var photoUrl = FileProvider.getUriForFile(this,
//                        "com.coutocode.cameraexample.fileprovider", photoFile)
//                    intent.putExtra(MediaStore.EXTRA_OUTPUT, photoUrl)
//                    startActivityForResult(intent, TAKE_PICTURE)
//                }
//            }
//        }
//
//    fun createImage(): File{
//        val timeStamp = SimpleDateFormat("yyyyMMdd_HHmmss").format(Date())
//        val imageName = "JPEG_" + timeStamp + "_"
//        val storageDir = context?.getExternalFilesDir(Environment.DIRECTORY_PICTURES)
//        val image = File.createTempFile(imageName, ".jpg", storageDir)
//        currentPath = image.absolutePath
//        return image
//    }
//}
