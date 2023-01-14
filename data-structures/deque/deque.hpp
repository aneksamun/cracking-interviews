/*
 * Deque.hpp
 *
 *  Created on: Apr 29, 2012
 */
#ifndef DEQUE_HPP_
#define DEQUE_HPP_

#include <cassert>
#include <iostream>

template<class T>
class Deque {
private:
    Node<T>* front;
    Node<T>* rear;
    unsigned size;

public:
    Deque() {
        size = 0;
        front = NULL;
        rear = NULL;
    }

    void push_front(T element) {
        // Create a new node
        Node<T>* tmp = new Node<T>();
        tmp->data = element;
        tmp->next = NULL;
        tmp->prev = NULL;

        if (is_empty()) {
            // Add a first element;
            front = rear = tmp;
        } else {
            // Fix links
            tmp->next = front;
            front->prev = tmp;
            front = tmp;
        }

        size++;
    }

    T pop_front() {
        assert(!is_empty());

        // Data in the front node
        T ret = front->data;

        // Delete the front node and fix the links
        Node* tmp = front;
        if (front->next != NULL) {
            front = front->next;
            front->prev = NULL;
        } else front = NULL;

        delete tmp;
        size--;

        return ret;
    }

    T front() {
        assert(!is_empty());
        return front->data;
    }

    void push_back(T element) {
        // Create a new node
        Node<T>* tmp = new Node<T>();
        tmp->data = element;
        tmp->next = NULL;
        tmp->prev = NULL;

        if (is_empty()) {
            // Add a first element;
            front = rear = tmp;
        } else {
            // Prepend to the list and fix links
            tmp->prev = rear;
            rear->next = tmp;
            rear = tmp;
        }

        size++;
    }

    T pop_back() {
        assert(!is_empty());

        // Data in the rear node
        T ret = rear->data;

        // Delete the rear node and fix the links
        Node* tmp = rear;
        if (rear->prev != NULL) {
            rear = rear->prev;
            rear->next = NULL;
        } else rear = NULL;

        delete tmp;
        size--;

        return ret;
    }

    T back() {
        assert(!is_empty());
        return rear->data;
    }

    unsigned size() {
        return size;
    }

    bool is_empty() {
        return size == 0;
    }
};

#endif /* DEQUE_HPP_ */

