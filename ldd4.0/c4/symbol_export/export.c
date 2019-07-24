#include <linux/init.h>
#include <linux/module.h>

int module_sum(int a, int b)
{
	printk(KERN_INFO "Module sum:%d\n", a+b);
	return a+b;
}
EXPORT_SYMBOL_GPL(module_sum);

int module_sub(int a, int b)
{
	printk(KERN_INFO "Module sub:%d\n", a-b);
	return a-b;
}
EXPORT_SYMBOL_GPL(module_sub);

MODULE_AUTHOR("Xiaofan Lee <lixiaofan0122@gmail.com>");
MODULE_LICENSE("GPL v2");
MODULE_DESCRIPTION("A example of export module");
MODULE_VERSION("V1.0");
