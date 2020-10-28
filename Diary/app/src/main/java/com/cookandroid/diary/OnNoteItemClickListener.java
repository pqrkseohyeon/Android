package com.cookandroid.diary;

import android.view.View;

//각 아이템을 선택했을 때 이벤트를 처리하기 위해서 사용
public interface OnNoteItemClickListener {
    public void onItemClick(NoteAdapter.ViewHolder holder, View view, int position);
}
