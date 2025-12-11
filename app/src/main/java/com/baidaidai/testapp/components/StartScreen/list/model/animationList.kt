package com.baidaidai.testapp.components.StartScreen.list.model

import com.baidaidai.testapp.components.animation.demo.singel.*
import com.baidaidai.testapp.R
import com.baidaidai.testapp.shared.dataClass.AnimationDatas


val animationList = listOf<AnimationDatas>(
    AnimationDatas(
        id = 0,
        name = "AnimateColorAsState",
        shortInfo = R.string.animateColorAsState_shortInfo,
        details = R.string.animateColorAsState_details,
        animationFiles = {blueState -> animateColorAsState(blueState) }
    ),
    AnimationDatas(
        id = 1,
        name = "AnimateContentSize",
        shortInfo = R.string.animateContentSize_shortInfo,
        details = R.string.animateContentSize_details,
        animationFiles = {blueState-> animateContentSize(blueState) }
    ),
    AnimationDatas(
        id = 2,
        name = "AnimateContentVisibility",
        shortInfo = R.string.animateContentVisibility_shortInfo,
        details = R.string.animateContentVisibility_details,
        animationFiles = {blueState-> animateContentVisibility(blueState) }
    ),
    AnimationDatas(
        id = 3,
        name = "AnimateOpacityAsState",
        shortInfo = R.string.animateOpacityAsState_shortInfo,
        details = R.string.animateOpacityAsState_details,
        animationFiles = {blueState-> animateOpacityAsState(blueState) }
    ),
    AnimationDatas(
        id = 4,
        name = "ShareTransition",
        shortInfo = R.string.shareTransition_shortInfo,
        details = R.string.shareTransition_details,
        animationFiles = {blueState-> shareTransition(blueState) }
    ),
    AnimationDatas(
        id = 5,
        name = "UpdateTransition",
        shortInfo = R.string.updateTransition_shortInfo,
        details = R.string.updateTransition_details,
        animationFiles = {blueState-> _updateTransition(blueState) }
    )
)