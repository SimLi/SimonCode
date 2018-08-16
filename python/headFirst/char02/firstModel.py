def print_loop(the_list):
    for each_item in the_list:
        if isinstance(each_item,list):
            print_loop(each_item)
        else:
            print(each_item)
