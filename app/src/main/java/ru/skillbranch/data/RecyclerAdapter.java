package ru.skillbranch.data;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import java.util.List;

import ru.skillbranch.data.utils.ConstantManager;
import ru.skillbranch.data.network.database.Member;
import ru.skillbranch.got.R;

/**
 * Created by root on 20.10.2016.
 */

public class RecyclerAdapter extends RecyclerView.Adapter<RecyclerAdapter.MemberViewHolder> {

    private Context mContext;
    private List<Member> mDataset;
    private int mHouseId;
    private MemberViewHolder.CustomClickListener mCustomClickListener;

    public RecyclerAdapter(List<Member> listMember, int id, MemberViewHolder.CustomClickListener customClickListener) {
        mDataset = listMember;
        mHouseId = id;
        this.mCustomClickListener = customClickListener;
    }

    @Override
    public MemberViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        mContext = parent.getContext();
        View v = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.recycler_item, parent, false);

        MemberViewHolder viewHolder = new MemberViewHolder(v, mCustomClickListener);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(MemberViewHolder holder, int position) {

        final Member member = mDataset.get(position);
        holder.mName.setText(mDataset.get(position).getName().toString());
        holder.mWords.setText(mDataset.get(position).getWords().toString());
        switch (mHouseId) {
            case ConstantManager.STARKS_HOUSE_ID:
                holder.mImageView.setImageResource(R.drawable.stark);
                break;
            case ConstantManager.LANNISTERS_HOUSE_ID:
                holder.mImageView.setImageResource(R.drawable.lanister);
                break;
            case ConstantManager.TARGARYENS_HOUSE_ID:
                holder.mImageView.setImageResource(R.drawable.targarien);
                break;
            default:
                holder.mImageView.setImageResource(R.drawable.starkhouse);
        }

    }


    @Override
    public int getItemCount() {
        return mDataset.size();
    }


    public static class MemberViewHolder extends RecyclerView.ViewHolder implements OnClickListener {

        public TextView mName;
        public TextView mWords;
        public ImageView mImageView;
        private CustomClickListener mListener;
        public LinearLayout mLinearLayout;

        public MemberViewHolder(View itemView, CustomClickListener customClickListener) {
            super(itemView);

            this.mListener = customClickListener;
            mName = (TextView) itemView.findViewById(R.id.recycle_item_name_tv);
            mWords = (TextView) itemView.findViewById(R.id.recycle_item_words_tv);
            mImageView = (ImageView) itemView.findViewById(R.id.recycle_item_img);
            mLinearLayout = (LinearLayout) itemView.findViewById(R.id.linearSel);

            mLinearLayout.setOnClickListener(this);

        }


        @Override
        public void onClick(View v) {
            if (mListener != null) {
                mListener.onUserItemClickListener(getAdapterPosition());
            }
        }

        public interface CustomClickListener {
            void onUserItemClickListener(int position);
        }
    }
}
