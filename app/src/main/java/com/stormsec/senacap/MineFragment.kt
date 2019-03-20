package com.stormsec.senacap

import android.app.Activity
import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.ImageView
import kotlinx.android.synthetic.main.fragment_mine.*


class MineFragment : Fragment(){
    private lateinit var imageview : ImageView
    private lateinit var buyNowButton : Button
    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return inflater.inflate(R.layout.fragment_mine, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        imageview = mine
        buyNowButton = buyNow

        imageview.setOnClickListener{
            Navigation.goToTitle(context as Activity)
        }
    }
}