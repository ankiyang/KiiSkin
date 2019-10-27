package com.example.kiiskin

import android.app.Activity
import androidx.fragment.app.Fragment
import android.content.Intent
import android.content.pm.PackageManager
import android.net.Uri
import android.os.Bundle
import android.os.Environment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.provider.MediaStore
import androidx.core.content.FileProvider

import java.io.IOException
import java.util.*
import java.io.File
import java.text.SimpleDateFormat

import kotlinx.android.synthetic.main.fragment_fragment_one.*



class FragmentOne : Fragment() {

    var currentPath:String? = null
    var TAKE_PICTURE = 1
    var SELECT_PICTURE = 2

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        return inflater.inflate(R.layout.fragment_fragment_one, container, false)

    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
//        fragment_photolog.text = "Fragment Photolog"
        buttonGallery.setOnClickListener {
            dispatchGalleryIntent()
        }
        buttonCamera.setOnClickListener {
            this.dispatchCameraIntent()
        }
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        if (requestCode == TAKE_PICTURE && resultCode == Activity.RESULT_OK){
            try {
                val file = File(currentPath)
                val url = Uri.fromFile(file)
                imageView.setImageURI(url)
            }
            catch (e: IOException){
                e.printStackTrace()
            }
        }
        if (requestCode == SELECT_PICTURE && resultCode == Activity.RESULT_OK){
            try {
                val uri = data!!.data
                imageView.setImageURI(uri)
            }
            catch (e: IOException){
                e.printStackTrace()
            }
        }
    }

    fun dispatchGalleryIntent(){
        val intent = Intent()
        intent.type = "image/+"
        intent.action = Intent.ACTION_GET_CONTENT
        startActivityForResult(Intent.createChooser(intent, "Select image"), SELECT_PICTURE)
    }

    fun dispatchCameraIntent(){
            var intent = Intent(MediaStore.ACTION_IMAGE_CAPTURE)
            if (intent.resolveActivity(PackageManager) != null){
                var photoFile: File? = null
                try{
                    photoFile = createImage()
                }catch (e: IOException){
                    e.printStackTrace()
                }
                if (photoFile != null) {
                    var photoUrl = FileProvider.getUriForFile(this,
                        "com.coutocode.cameraexample.fileprovider", photoFile)
                    intent.putExtra(MediaStore.EXTRA_OUTPUT, photoUrl)
                    startActivityForResult(intent, TAKE_PICTURE)
                }
            }
        }

    fun createImage(): File{
        val timeStamp = SimpleDateFormat("yyyyMMdd_HHmmss").format(Date())
        val imageName = "JPEG_" + timeStamp + "_"
        val storageDir = context?.getExternalFilesDir(Environment.DIRECTORY_PICTURES)
        val image = File.createTempFile(imageName, ".jpg", storageDir)
        currentPath = image.absolutePath
        return image
    }
}
