package com.cookandroid.project_to_do_list;
// 객체를 하나 생성한다. 기본적으로 생성자와 Getter를 만든다.
// ArrayList에서 리스트 하나에 들어갈 데이터를 갖고 있는 Todo 클래스이다.
// ArrayList<Todo(객체)> todoArrayList(이름)의 형태로 선언 되어 RecyclerView의 데이터셋으로 사용된다.


public class Todo {
    private String todoName;

    //생성자
    public  Todo(String todoName){
        this.todoName = todoName;
    }

    //getter
    public String getTodoName(){
        return  todoName;
    }

}
