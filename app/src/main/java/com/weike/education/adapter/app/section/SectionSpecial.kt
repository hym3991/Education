package com.weike.education.adapter.app.section

import android.content.Intent
import android.support.constraint.ConstraintLayout
import com.bumptech.glide.Glide
import com.bumptech.glide.load.engine.DiskCacheStrategy
import com.weike.education.R
import com.weike.education.bean.app.SelectionBean
import com.weike.education.model.app.SectionDetailActivity
import com.weike.education.widget.section.StatelessSection
import com.weike.education.widget.section.ViewHolder
import jp.wasabeef.glide.transformations.RoundedCornersTransformation


/**
 * @author: ym  作者 E-mail: 15622113269@163.com
 * date: 2018/11/21
 * desc: 首页-名师推荐-section
 *
 */
class SectionSpecial(list: List<SelectionBean.Data.Zhuanlan>?) : StatelessSection<SelectionBean.Data.Zhuanlan>(R.layout.layout_item_section_head, R.layout.layout_item_special_body, list) {

    override fun convert(holder: ViewHolder?, zhuanlan: SelectionBean.Data.Zhuanlan?, position: Int) {
        holder?.apply {
            zhuanlan?.let {
                if (position != 0) getView<ConstraintLayout>(R.id.item).setBackgroundResource(R.drawable.ic_bottom_lines)

                setText(R.id.special_title, zhuanlan.title)
                setText(R.id.special_teacherName, zhuanlan.teacherName)
                setText(R.id.special_teacherTag, zhuanlan.teacherTag)
                setText(R.id.special_content, zhuanlan.introduction)

                Glide.with(mContext)
                        .load(zhuanlan.img)
                        .diskCacheStrategy(DiskCacheStrategy.ALL)
                        .bitmapTransform(RoundedCornersTransformation(mContext, 5, 0))
                        .into(getView(R.id.special_imgView))

                itemView.setOnClickListener {
                    mContext.startActivity(Intent(mContext, SectionDetailActivity::class.java))
                }
            }
        }
    }


    override fun onBindHeaderViewHolder(holder: ViewHolder?) {
        holder?.setText(R.id.headTitle, R.string.head_zhuanlan)?.setVisible(R.id.headMore, false)
    }
}