#include <linux/init.h>
#include <linux/module.h>

static char *book_name = "Linux Device Driver";
module_param(book_name, charp, S_IRUGO);
static int book_num = 100;
module_param(book_num, int, S_IRUGO);

static int __init book_init(void)
{
	printk(KERN_INFO "Book name:%s\n", book_name);
	printk(KERN_INFO "Book num:%d\n", book_num);
	return 0;
}
module_init(book_init);

static void __exit book_exit(void)
{
	printk(KERN_INFO "Book module exit\n");
}
module_exit(book_exit);

MODULE_AUTHOR("Xiaofan Lee <lixiaofan0122@gmail.com>");
MODULE_LICENSE("GPL v2");
MODULE_DESCRIPTION("A example of Book module");
MODULE_VERSION("V1.0");
