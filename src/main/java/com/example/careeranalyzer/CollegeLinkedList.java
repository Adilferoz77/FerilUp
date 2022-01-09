package com.example.careeranalyzer;

public class CollegeLinkedList {
    CollegeNode head = null;
    CollegeNode tail = null;
    int size =0;

    public void insertInstitute(College college){
        CollegeNode newNode = new CollegeNode(college);
        if(head == null){
            head = newNode;
        }else{
            CollegeNode temp = head;
            while (temp.next!=null){
                temp = temp.next;
            }
            temp.next = newNode;
        }
        tail = newNode;
        size++;
    }
}

class CollegeNode{
    College college;
    CollegeNode next;

    CollegeNode(College college){
        this.college = college;
        this.next = null;
    }
}
