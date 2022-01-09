package com.example.careeranalyzer;

public class UniversityLinkedList {
    UniversityNode head = null;
    UniversityNode tail = null;
    int size =0;

    public void insertInstitute(University university){
        UniversityNode newNode = new UniversityNode(university);
        if(head == null){
            head = newNode;
        }else{
            UniversityNode temp = head;
            while (temp.next!=null){
                temp = temp.next;
            }
            temp.next = newNode;
        }
        tail = newNode;
        size++;
    }
}

class UniversityNode{
    University university;
    UniversityNode next;

    UniversityNode(University university){
        this.university = university;
        this.next = null;
    }
}