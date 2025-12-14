package com.baidaidai.animora.components.StartScreen.list.model

import com.baidaidai.animora.components.animation.demo.singel.*
import com.baidaidai.animora.R
import com.baidaidai.animora.components.animation.demo.animatable
import com.baidaidai.animora.components.animation.demo.infiniteTransition
import com.baidaidai.animora.shared.dataClass.AnimationDatas


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
    ),
    AnimationDatas(
        id = 6,
        name = "Animatable",
        shortInfo = R.string.AnimateTo_shortInfo,
        details = R.string.AnimateTo_details,
        animationFiles = { blueState -> animatable.AnimateTo(blueState) }
    ),
    AnimationDatas(
        id = 7,
        name = "WithMediumSpringSpec",
        shortInfo = R.string.withMediumSpringSpec_shortInfo,
        details = R.string.withMediumSpringSpec_details,
        animationFiles = { blueState -> animatable.withMediumSpringSpec(blueState) }
    ),
    AnimationDatas(
        id = 8,
        name = "WithDIYBezier",
        shortInfo = R.string.withDIYBezier_shortInfo,
        details = R.string.withDIYBezier_details,
        animationFiles = { blueState -> animatable.withDIYBezier(blueState) }
    ),
    AnimationDatas(
        id = 9,
        name = "WithKeyframesSpline",
        shortInfo = R.string.withKeyframesSpline_shortInfo,
        details = R.string.withKeyframesSpline_details,
        animationFiles = { blueState -> animatable.withKeyframesSpline(blueState) }
    ),
    AnimationDatas(
        id = 10,
        name = "WithInfinityRepeatable",
        shortInfo = R.string.withInfinityRepeatable_shortInfo,
        details = R.string.withInfinityRepeatable_details,
        animationFiles = { blueState -> animatable.withInfinityRepeatable(blueState) }
    ),
    AnimationDatas(
        id = 11,
        name = "WithSnap",
        shortInfo = R.string.withSnap_shortInfo,
        details = R.string.withSnap_details,
        animationFiles = { blueState -> animatable.withSnap(blueState) }
    ),
    AnimationDatas(
        id = 12,
        name = "AnimateColor",
        shortInfo = R.string.animateColor_shortInfo,
        details = R.string.animateColor_details,
        animationFiles = { infiniteTransition.animateColor() }
    ),
    AnimationDatas(
        id = 13,
        name = "AnimateFloat",
        shortInfo = R.string.animateFloat_shortInfo,
        details = R.string.animateFloat_details,
        animationFiles = { infiniteTransition.animateFloat() }
    )
)