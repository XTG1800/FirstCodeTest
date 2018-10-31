package com.example.uibestpractice;


import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

import java.util.List;

import static com.example.uibestpractice.Msg.TYPE_RECEIVED;

public class MsgAdapter extends RecyclerView.Adapter<MsgAdapter.ViewHolder>{

    private List<Msg> mMsgList;

    static class ViewHolder extends RecyclerView.ViewHolder {
        public LinearLayout linearLayoutReceived;
        public LinearLayout linearLayoutSent;
        public TextView textViewReceived;
        public TextView textViewSent;

        public ViewHolder(View view) {
            super(view);
            linearLayoutReceived = (LinearLayout) view.findViewById(R.id.left_layout);
            linearLayoutSent = (LinearLayout) view.findViewById(R.id.right_layout);
            textViewReceived = (TextView) view.findViewById(R.id.left_text_view);
            textViewSent = (TextView) view.findViewById(R.id.right_text_view);
        }
    }

    public MsgAdapter(List<Msg> msgList) {
        mMsgList = msgList;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.msg_item, parent, false);
        ViewHolder holder = new ViewHolder(view);
        return holder;
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        Msg msg = mMsgList.get(position);
        if(msg.getType() == TYPE_RECEIVED) {
            holder.linearLayoutReceived.setVisibility(View.VISIBLE);
            holder.linearLayoutSent.setVisibility(View.GONE);
            //INVISIBLE和GONE的主要区别是：当控件visibility属性为INVISIBLE时，界面保留了view控件所占有的空间；而控件属性为GONE时，界面则不保留view控件所占有的空间
            holder.textViewReceived.setText(msg.getContent());
        } else {
            holder.linearLayoutSent.setVisibility(View.VISIBLE);
            holder.linearLayoutReceived.setVisibility(View.GONE);
            //INVISIBLE和GONE的主要区别是：当控件visibility属性为INVISIBLE时，界面保留了view控件所占有的空间；而控件属性为GONE时，界面则不保留view控件所占有的空间
            holder.textViewSent.setText(msg.getContent());
        }
    }

    @Override
    public int getItemCount() {
        return mMsgList.size();
    }
}
