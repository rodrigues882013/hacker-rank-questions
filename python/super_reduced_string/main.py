'''
abd
abccddd
abddd
abd

baab
bb
'''

def superReducedString(s):

    i = 0
    while s != '' and i < len(s) - 1:
        j = i + 1
        
        if s[i] == s[j]:
            s = s[:i] + s[j:]
            s = s[:j-1] + s[j:]
            i = 0
        else:
            i += 1
    
    return s if len(s) > 0 else 'Empty String'


def main():
    # print(superReducedString('aaabccddd'))
    # print(superReducedString('baab'))
    print(superReducedString('aa'))
    
if __name__ == "__main__":
    main()