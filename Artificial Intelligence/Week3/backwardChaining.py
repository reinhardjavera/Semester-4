knowledge_base = {
    "A": ["B", "C"],
    "B": ["D"],
    "C": ["E"],
    "D": ["F"],
    "E": ["F"],
    "F": ["G"]
}

def backward_chaining(goal):
    if goal in knowledge_base:
        for premise in knowledge_base[goal]:
            if backward_chaining(premise):
                print(f"{goal} dapat dicapai melalui {premise}")
                return True
    return False

# Tujuan yang ingin dicapai
target_goal = "G"
if backward_chaining(target_goal):
    print(f"Tujuan {target_goal} berhasil dicapai!")
else:
    print(f"Tujuan {target_goal} tidak dapat dicapai.")
